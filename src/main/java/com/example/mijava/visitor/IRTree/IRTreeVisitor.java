package com.example.mijava.visitor.IRTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.expression.spel.ast.Assign;
import org.springframework.expression.spel.ast.Identifier;

import com.example.mijava.ast.Add;
import com.example.mijava.ast.AndExpression;
import com.example.mijava.ast.ArrayAccessExpression;
import com.example.mijava.ast.ArrayAssignStatement;
import com.example.mijava.ast.ArrayLengthExpression;
import com.example.mijava.ast.AssignStatement;
import com.example.mijava.ast.BinaryExpression;
import com.example.mijava.ast.BlockStatement;
import com.example.mijava.ast.BooleanLiteralExpression;
import com.example.mijava.ast.BooleanType;
import com.example.mijava.ast.ClassDecl;
import com.example.mijava.ast.ClassDeclExtends;
import com.example.mijava.ast.ClassDeclSimple;
import com.example.mijava.ast.FalseExpression;
import com.example.mijava.ast.FormalList;
import com.example.mijava.ast.Id;
import com.example.mijava.ast.IdentifierExpression;
import com.example.mijava.ast.IdentifierType;
import com.example.mijava.ast.IfStatement;
import com.example.mijava.ast.IntArrayType;
import com.example.mijava.ast.IntegerLiteralExpression;
import com.example.mijava.ast.IntegerType;
import com.example.mijava.ast.LessThan;
import com.example.mijava.ast.MainClass;
import com.example.mijava.ast.MethodCallExpression;
import com.example.mijava.ast.MethodDecl;
import com.example.mijava.ast.Mul;
import com.example.mijava.ast.NewArrayExpression;
import com.example.mijava.ast.NewObjectExpression;
import com.example.mijava.ast.NotExpression;
import com.example.mijava.ast.PrintStatement;
import com.example.mijava.ast.Program;
import com.example.mijava.ast.Sub;
import com.example.mijava.ast.ThisExpression;
import com.example.mijava.ast.TrueExpression;
import com.example.mijava.ast.Type;
import com.example.mijava.ast.VarDecl;
import com.example.mijava.ast.WhileStatement;
import com.example.mijava.irtree.BINOP;
import com.example.mijava.irtree.CALL;
import com.example.mijava.irtree.CJUMP;
import com.example.mijava.irtree.CONST;
import com.example.mijava.irtree.ESEQ;
import com.example.mijava.irtree.EXP;
import com.example.mijava.irtree.ExpAbstract;
import com.example.mijava.irtree.ExpList;
import com.example.mijava.irtree.JUMP;
import com.example.mijava.irtree.LABEL;
import com.example.mijava.irtree.MEM;
import com.example.mijava.irtree.MOVE;
import com.example.mijava.irtree.NAME;
import com.example.mijava.irtree.SEQ;
import com.example.mijava.irtree.Stm;
import com.example.mijava.irtree.TEMP;
import com.example.mijava.mips.MipsFrame;
import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.symbol.SymbolEntry;
import com.example.mijava.temp.Label;
import com.example.mijava.visitor.ASTVisitor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.var;
import lombok.extern.log4j.Log4j2;



@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Log4j2
public class IRTreeVisitor implements ASTVisitor<Exp>{
    private MipsFrame frame;
	private Frag frag;
	private Frag initialFrag;
	@Builder.Default
	private List<ExpAbstract> listExp = new ArrayList<>();
	@Builder.Default
	private SymTabScopeNode mainTable = new SymTabScopeNode(null, null);
	@Builder.Default
	private SymTabScopeNode currentClassTable = null;
	@Builder.Default
	private SymTabScopeNode currentMethodTable = null;


	public IRTreeVisitor(SymTabScopeNode symTabScopeNode, MipsFrame frame) {
		this.mainTable = symTabScopeNode;
		this.frame = frame;
		this.frag = new Frag(null);
		this.initialFrag = this.frag;
		this.listExp = new ArrayList<>();
	}


	public Exp visit(AndExpression a) {
		var lheExpr = a.left.accept(this);
		var rheExpr = a.right.accept(this);

		var andBinop = BINOP.builder()
			.binop(BINOP.AND)
			.left(lheExpr.unEx()).right(rheExpr.unEx())
			.build();

		addExp(andBinop);
		return new Exp(andBinop);
	}

	public Exp visit(BooleanType b) {
		return null;
	}

	public Exp visit(NotExpression n) {
		var exp = n.getE().accept(this);

		var notBinop = BINOP.builder()
			.binop(BINOP.MINUS)
			.left(new CONST(1))
			.right(exp.unEx())
			.build();
		addExp(notBinop);
		return new Exp(notBinop);
	}

	public Exp visit(TrueExpression t) {
		var constExpr = new CONST(1);
		addExp(constExpr);
		return new Exp(constExpr);
	}

	public Exp visit(FalseExpression f) {
		var constExpr = new CONST(0);
		addExp(constExpr);
		return new Exp(constExpr);
	}

	public Exp visit(Identifier i) {
		var allocLocal = frame.allocLocal();
		var tempReg = allocLocal.exp(new TEMP(frame.FP()));
		addExp(tempReg);
		return new Exp(tempReg);
	}

	public Exp visit(MethodCallExpression c) {
		SymTabScopeNode tmpClassTable = null;
		SymTabScopeNode tmpMethodTable;
		String tmpClassSymbol = null;
		ExpList expList = null;

		int size = c.arguments.size();

		for (int i = size - 1; i >= 0; i--) {
			var expr = c.arguments.get(i).accept(this);
			expList = new ExpList(expr.unEx(), expList);
		}

		expList = new ExpList(c.object.accept(this).unEx(), expList);

		if (c.object instanceof MethodCallExpression) {
			tmpClassTable = currentClassTable;

			tmpMethodTable = tmpClassTable.getMethodScope(c.methodName.getS());

			tmpClassTable = tmpMethodTable.getParent(); 
		}

		if (c.object instanceof IdentifierExpression idExp) {
			SymbolEntry entry = currentMethodTable.getSymTab(idExp.getS());
			if (entry == null && currentClassTable != null) {
				entry = currentClassTable.getSymTab(idExp.getS());
			}
			if (entry != null) {
				tmpClassSymbol = entry.getType();
			}
        }

		if (c.object instanceof NewObjectExpression idNewObject) {
			tmpClassTable = mainTable.getClassScope(idNewObject.getId().getS()); 
		}
		if (c.object instanceof ThisExpression) tmpClassTable = currentClassTable;
		if (tmpClassTable != null) tmpClassSymbol = tmpClassTable.getScopename();

		var label = new Label(tmpClassSymbol + "." + c.getMethodName().getS());

		var callExpr = CALL.builder()
			.func(new NAME(label))
			.args(expList)
			.build();
		addExp(callExpr);
		return new Exp(callExpr);
	}

	public Exp visit(IdentifierExpression i) {
		var allocLocal = frame.allocLocal();
		var tempReg = allocLocal.exp(new TEMP(frame.FP()));
		addExp(tempReg);
		return new Exp(tempReg);
	}

	public Exp visit(IdentifierType i) {
		return null;
	}

	public Exp visit(NewObjectExpression n) {
		SymTabScopeNode classScope = mainTable.getClassScope(n.getId().getS());	
		currentClassTable = classScope;

		int sizeOfFields = 0;
		for(SymbolEntry entry: classScope.getSymTab().values()){
			if(entry.getKind().equals("var")){
				sizeOfFields ++;
			}
		}

		var parametersList = new LinkedList<ExpAbstract>();
		parametersList.add(
			BINOP.builder()
				.binop(BINOP.MUL)
				.left(new CONST(sizeOfFields + 1))
				.right(new CONST(frame.wordSize()))
				.build()
		);

		var externalCall = frame.externalCall("malloc", parametersList);
		addExp(externalCall);
		return new Exp(externalCall);
	}

	public Exp visit(ThisExpression t) {
		var tempAllocation = MEM.builder()
			.exp(new TEMP(frame.FP()))
			.build();
		addExp(tempAllocation);
		return new Exp(tempAllocation);
	}

	public Exp visit(ArrayAccessExpression a) {
		var idx = a.getRight().accept(this);
		var array = a.getLeft().accept(this);

		var arrayLoopUp = MEM.builder()
			.exp(
				BINOP.builder()
					.binop(BINOP.PLUS)
					.left(array.unEx())
					.right(
						BINOP.builder()
							.binop(BINOP.MUL)
							.left(idx.unEx())
							.right(new CONST(frame.wordSize()))
							.build()
					)
					.build()
			)
			.build();
		addExp(arrayLoopUp);
		return new Exp(arrayLoopUp);
	}

	public Exp visit(ArrayAssignStatement a) {
		var id = a.getI().accept(this);
		var idx = a.getE1().accept(this);
		var val = a.getE2().accept(this);

		var offset = BINOP.builder()
			.binop(BINOP.MUL)
			.left(idx.unEx())
			.right(new CONST(frame.wordSize()))
			.build();
		var pointer = BINOP.builder()
			.binop(BINOP.PLUS)
			.left(BINOP.builder()
				.binop(BINOP.PLUS)
				.left(id.unEx()).right(new CONST(1))
				.build()
			)
			.right(offset)
			.build();

		var move = MOVE.builder()
			.dst(new MEM(pointer))
			.src(val.unEx())
			.build();

		var arrayAssign = ESEQ.builder()
			.stm(move)
			.exp(new CONST(0))
			.build();
		addExp(arrayAssign);
		return new Exp(arrayAssign);
	}

	public Exp visit(ArrayLengthExpression a) {
		var pointer = a.getArray().accept(this);

		var tempAlloc = MEM.builder()
			.exp(pointer.unEx())
			.build();
		addExp(tempAlloc);
		return new Exp(tempAlloc);
	}

	public Exp visit(Add p) {
		var lheExpr = p.getLeft().accept(this);
		var rheExpr = p.getRight().accept(this);

		var plusBinop = BINOP.builder()
			.binop(BINOP.PLUS)
			.left(lheExpr.unEx())
			.right(rheExpr.unEx())
			.build();
		addExp(plusBinop);
		return new Exp(plusBinop);
	}

	public Exp visit(Sub m) {
		var lheExpr = m.getLeft().accept(this);
		var rheExpr = m.getRight().accept(this);

		var minusBinop = BINOP.builder()
			.binop(BINOP.MINUS)
			.left(lheExpr.unEx())
			.right(rheExpr.unEx())
			.build();
		addExp(minusBinop);
		return new Exp(minusBinop);
	}

	public Exp visit(Mul t) {
		var lheExpr = t.getLeft().accept(this);
		var rheExpr = t.getRight().accept(this);

		var timeBinop = BINOP.builder()
			.binop(BINOP.MUL)
			.left(lheExpr.unEx())
			.right(rheExpr.unEx())
			.build();
		addExp(timeBinop);
		return new Exp(timeBinop);
	}

	public Exp visit(IntegerLiteralExpression i) {
		var integerValue = new CONST(i.getValue());
		addExp(integerValue);
		return new Exp(integerValue);
	}

	public Exp visit(IntegerType i) {
		return null;
	}

	public Exp visit(IntArrayType i) {
		return null;
	}

	public Exp visit(LessThan l) {
		var lheExpr = l.left.accept(this);
		var rheExpr = l.right.accept(this);

		var lessThanBinop = BINOP.builder()
			.binop(BINOP.MINUS)
			.left(lheExpr.unEx())
			.right(rheExpr.unEx())
			.build();
		addExp(lessThanBinop);
		return new Exp(lessThanBinop);
	}

	public Exp visit(NewArrayExpression n) {
		var newArraySize = n.e.accept(this);
		var parametersList = new LinkedList<ExpAbstract>();

		// mem size to alloc
		var exp = BINOP.builder()
			.binop(BINOP.MUL)
			.left(
				BINOP.builder()
					.binop(BINOP.PLUS)
					.left(newArraySize.unEx())
					.right(new CONST(1))
					.build()
			)
			.right(new CONST(frame.wordSize()))
			.build();

		parametersList.add(exp);

		var arrayAlloc = frame.externalCall("initArray", parametersList);
		addExp(arrayAlloc);
		return new Exp(arrayAlloc);
	}

	public Exp visit(WhileStatement w) {
		var cond = w.getCondition().accept(this).unEx();
		var body = new EXP(w.getBody().accept(this).unEx());

		var condLabel = new Label();
		var bodyLabel = new Label();
		var endLabel = new Label();

		var bodyStm = new SEQ(new LABEL(bodyLabel), body);
		var condJump = new JUMP(condLabel);
		var bodyJump = new SEQ(bodyStm, condJump);

		// LessThan: uses Minus in your implementation BINOP
		var cjump = CJUMP.builder()
			.relop(CJUMP.GT)
			.left(cond)
			.right(new CONST(1))
			.iftrue(bodyLabel)
			.iffalse(endLabel)
			.build();

		var whileStatement = SEQ.builder()
			.left(
				SEQ.builder()
					.left(
						SEQ.builder()
							.left(new LABEL(condLabel))
							.right(cjump)
							.build()
					)
					.right(bodyJump)
					.build()
			)
			.right(new LABEL(endLabel))
			.build();


		var whileEseq = new ESEQ(whileStatement, null);
		addExp(whileEseq);
		return new Exp(whileEseq);
	}

	public Exp visit(IfStatement i) {
		var trueLabel = new Label();
		var falseLabel = new Label();
		var endLabel = new Label();

		var condExpr = i.getCondition().accept(this);
		var trueStmt = new EXP(i.getThenStatement().accept(this).unEx());
		var falseStmt = new EXP(i.getElseStatement().accept(this).unEx());

		var thenStatement = new SEQ(
			new SEQ(new LABEL(trueLabel), trueStmt),
			new JUMP(endLabel)
		);
		var elseStatement = new SEQ(
			new SEQ(new LABEL(falseLabel), falseStmt),
			new JUMP(endLabel)
		);
		var thenElseStmt = new SEQ(thenStatement, elseStatement);

		var condStmt = CJUMP.builder()
			.relop(CJUMP.EQ)
			.left(new CONST(1))
			.right(condExpr.unEx())
			.iftrue(trueLabel)
			.iffalse(falseLabel)
			.build();

		var ifStmt = new SEQ(condStmt, thenElseStmt);

		var ifESEQ = new ESEQ(new SEQ(ifStmt, new LABEL(endLabel)), null);
		addExp(ifESEQ);
		return new Exp(ifESEQ);
	}

	public Exp visit(AssignStatement a) {
		System.out.println("oba: " + a.id.toString());

		var id = a.getId().accept(this);
		var value = a.getExpression().accept(this);

		var moveValue = MOVE.builder()
			.dst(id.unEx())
			.src(value.unEx())
			.build();

		var moveValueESEQ = ESEQ.builder()
			.stm(moveValue)
			.exp(new CONST(0))
			.build();
		addExp(moveValueESEQ);
		return new Exp(moveValueESEQ);
	}

	public Exp visit(PrintStatement s) {
		var argsList = new LinkedList<ExpAbstract>();
		var exp = s.expression.accept(this);
		argsList.add(exp.unEx());

		var call = frame.externalCall("print", argsList);
		addExp(call);
		return new Exp(call);
	}

	public Exp visit(BlockStatement b) {
		var size = b.getStatements().size();
		ExpAbstract expBlock = new CONST(0);

		for (int i = 0; i < size; i++) {
			var expr = new EXP(b.getStatements().get(i).accept(this).unEx()); 

			expBlock = ESEQ.builder()
				.stm(
					SEQ.builder()
						.left(new EXP(expBlock))
						.right(expr)
						.build()
				)
				.exp(new CONST(0))
				.build();
		}

		addExp(expBlock);
		return new Exp(expBlock);
	}

	public Exp visit(MainClass m) {
		currentClassTable = mainTable.getClassScope(m.getClassName().getS());
		currentMethodTable = currentClassTable.getMethodScope("main");
		Stm stmBody = new EXP(new CONST(0));
		var stmList = new ArrayList<Stm>();
		var escapeList = new ArrayList<Boolean>();
		escapeList.add(false);
		
		frame = frame.newFrame("main", escapeList);

		
		if(m.getStatement() != null){
			var stmExp = m.getStatement().accept(this).unEx();
			stmBody = new SEQ(stmBody, new EXP(stmExp));
		}

		stmList.add(stmBody);

		frame.procEntryExit1(stmList);
		frag.setNext(new ProcFrag(stmBody, frame));
		frag = frag.getNext();

		currentClassTable = null;
		currentMethodTable = null;
		return null;
	}

	public Exp visit(ClassDeclSimple c) {
		currentClassTable = mainTable.getClassScope(c.getId().getS()); 
		c.getId().accept(this);

		c.getVarDeclList().forEach(field -> field.accept(this)); 
		c.getMethodDeclList().forEach(method -> method.accept(this));

		currentClassTable = null;
		return null;
	}

	public Exp visit(ClassDeclExtends c) {
		currentClassTable = mainTable.getClassScope(c.getId().getS()); 

		c.getId().accept(this);
		c.getId2().accept(this);

		c.getMethodDeclList().forEach(method -> method.accept(this));
		c.getVarDeclList().forEach(field -> field.accept(this));

		currentClassTable = null;
		return null;
	}

	public Exp visit(Program p) {
		p.getMainClass().accept(this);
		p.getClasses().forEach(classDecl -> classDecl.accept(this));
		return null;
	}

	public Exp visit(MethodDecl m) {
		    
		SymTabScopeNode currentMethodTable = mainTable.getMethodScopeRecursive(m.getMethodName().toString(), currentClassTable);
     
		Stm stmBody = new EXP(new CONST(0));
		var escapeList = new ArrayList<Boolean>();
		int sizeFormals = m.getParameters().size();
		int sizeStatement = m.getStatements().size();  

		for (int i = 0; i <= sizeFormals; i++) {
			escapeList.add(false);
		}


		frame = frame.newFrame(
			currentClassTable.getScopename() + "$" + currentMethodTable.getScopename(),
			escapeList
		);

		m. getParameters().forEach(formal -> formal.accept(this));
		m.getVarDecls().forEach(varDecl -> varDecl.accept(this));

		for (int i = 0; i < sizeStatement; i++) {
			stmBody = new SEQ(
				stmBody,
				new EXP(
					m.getStatements().get(i).accept(this).unEx()
				)
			);
		}

		var stmList = new ArrayList<Stm>();
		stmList.add(stmBody);

		frame.procEntryExit1(stmList);
		frag.setNext(new ProcFrag(stmBody, frame));
		frag = frag.getNext();


		currentMethodTable = null;
		return null;
	}

	public Exp visit(VarDecl v) {
		return null;
	}

	public Exp visit(FormalList f) {
		frame.allocLocal();
		return null;
	}

	public void addExp(ExpAbstract exp) {
		listExp.add(exp);
	}


	@Override
	public Exp visit(ClassDecl classDecl) {
		return null;
	}


	@Override
	public Exp visit(Id id) {
		return null;
	}


	@Override
	public Exp visit(Type type) {
		return null;
	}


	@Override
	public Exp visit(BinaryExpression expression) {
		return null;
	}


	@Override
	public Exp visit(BooleanLiteralExpression expression) {
		return null;
	}
}
