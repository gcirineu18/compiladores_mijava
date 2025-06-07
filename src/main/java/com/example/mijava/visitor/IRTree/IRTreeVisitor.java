package com.example.mijava.visitor.IRTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.expression.spel.ast.Assign;
import org.springframework.expression.spel.ast.Identifier;

import com.example.mijava.ast.Add;
import com.example.mijava.ast.AndExpression;
import com.example.mijava.ast.BlockStatement;
import com.example.mijava.ast.BooleanType;
import com.example.mijava.ast.ClassDeclExtends;
import com.example.mijava.ast.ClassDeclSimple;
import com.example.mijava.ast.FalseExpression;
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
import com.example.mijava.ast.VarDecl;
import com.example.mijava.ast.WhileStatement;
import com.example.mijava.irtree.BINOP;
import com.example.mijava.irtree.CALL;
import com.example.mijava.irtree.CJUMP;
import com.example.mijava.irtree.CONST;
import com.example.mijava.irtree.ESEQ;
import com.example.mijava.irtree.EXP;
import com.example.mijava.irtree.Exp;
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
import com.example.mijava.temp.Label;
import com.example.mijava.visitor.ASTVisitor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
	private SymTabScopeNode symTabScopeNode = new SymTabScopeNode(null, null);


	public IRTreeVisitor(SymTabScopeNode symTabScopeNode, MipsFrame frame) {
		this.symTabScopeNode = symTabScopeNode;
		this.frame = frame;
		this.frag = new Frag(null);
		this.initialFrag = this.frag;
		this.listExp = new ArrayList<>();
	}

	public Exp visit(AndExpression a) {
		var lheExpr = a.getLhe().accept(this);
		var rheExpr = a.getRhe().accept(this);

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
		ClassTable tmpClassTable = null;
		MethodTable tmpMethodTable;
		String tmpClassSymbol = null;
		ExpList expList = null;

		int size = c.getExpressionList().getList().size();

		for (int i = size - 1; i >= 0; i--) {
			var expr = c.getExpressionList().getList().get(i).accept(this);
			expList = new ExpList(expr.unEx(), expList);
		}

		expList = new ExpList(c.getOwner().accept(this).unEx(), expList);

		if (c.getOwner() instanceof Call) {
			tmpClassTable = currentClassTable;

			tmpMethodTable = tmpClassTable.getMethodsContext().get(c.getMethod().getS());

			tmpClassTable = mainTable.getMap().get(tmpMethodTable.getClassParent().getClassName());
		}

		if (c.getOwner() instanceof IdentifierExpression idExp) {
			if (currentMethodTable.getLocalsContext().get(idExp.getId()) instanceof IdentifierType idType) {
				tmpClassSymbol = idType.getS();
			} else if (currentMethodTable.getParamsContext().get(idExp.getId()) instanceof IdentifierType idType)
				tmpClassSymbol = idType.getS();
			else if (currentClassTable.getFieldsContext().get(idExp.getId()) instanceof IdentifierType idType) {
				tmpClassSymbol = idType.getS();
			}
		}

		if (c.getOwner() instanceof NewObject idNewObject) {
			tmpClassTable = mainTable.getMap().get(idNewObject.getIdentifier().getS());
		}
		if (c.getOwner() instanceof This) tmpClassTable = currentClassTable;
		if (tmpClassTable != null) tmpClassSymbol = tmpClassTable.getClassName();

		var label = new Label(tmpClassSymbol + "." + c.getMethod().getS());

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
		currentClassTable = mainTable.getMap().get(n.getIdentifier().getS());
		int sizeOfFields = mainTable.getMap().get(n.getIdentifier().getS()).getFieldsContext().size();

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

	public Exp visit(ArrayLookup a) {
		var idx = a.getIdx().accept(this);
		var array = a.getArray().accept(this);

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

	public Exp visit(ArrayAssign a) {
		var id = a.getIdentifier().accept(this);
		var idx = a.getIndex().accept(this);
		var val = a.getValue().accept(this);

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

	public Exp visit(ArrayLength a) {
		var pointer = a.getArray().accept(this);

		var tempAlloc = MEM.builder()
			.exp(pointer.unEx())
			.build();
		addExp(tempAlloc);
		return new Exp(tempAlloc);
	}

	public Exp visit(Add p) {
		var lheExpr = p.getLhe().accept(this);
		var rheExpr = p.getRhe().accept(this);

		var plusBinop = BINOP.builder()
			.binop(BINOP.PLUS)
			.left(lheExpr.unEx())
			.right(rheExpr.unEx())
			.build();
		addExp(plusBinop);
		return new Exp(plusBinop);
	}

	public Exp visit(Sub m) {
		var lheExpr = m.getLhe().accept(this);
		var rheExpr = m.getRhe().accept(this);

		var minusBinop = BINOP.builder()
			.binop(BINOP.MINUS)
			.left(lheExpr.unEx())
			.right(rheExpr.unEx())
			.build();
		addExp(minusBinop);
		return new Exp(minusBinop);
	}

	public Exp visit(Mul t) {
		var lheExpr = t.getLhe().accept(this);
		var rheExpr = t.getRhe().accept(this);

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
		var lheExpr = l.getLhe().accept(this);
		var rheExpr = l.getRhe().accept(this);

		var lessThanBinop = BINOP.builder()
			.binop(BINOP.MINUS)
			.left(lheExpr.unEx())
			.right(rheExpr.unEx())
			.build();
		addExp(lessThanBinop);
		return new Exp(lessThanBinop);
	}

	public Exp visit(NewArrayExpression n) {
		var newArraySize = n.getSize().accept(this);
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
			.condTrue(bodyLabel)
			.condFalse(endLabel)
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
		var trueStmt = new EXP(i.getThenBranch().accept(this).unEx());
		var falseStmt = new EXP(i.getElseBranch().accept(this).unEx());

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
			.condTrue(trueLabel)
			.condFalse(falseLabel)
			.build();

		var ifStmt = new SEQ(condStmt, thenElseStmt);

		// sera que precisa desse ESEQ? IDK you tell me
		var ifESEQ = new ESEQ(new SEQ(ifStmt, new LABEL(endLabel)), null);
		addExp(ifESEQ);
		return new Exp(ifESEQ);
	}

	public Exp visit(Assign a) {
		var id = a.getIdentifier().accept(this);
		var value = a.getValue().accept(this);

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
		var exp = s.getExpression().accept(this);
		argsList.add(exp.unEx());

		var call = frame.externalCall("print", argsList);
		addExp(call);
		return new Exp(call);
	}

	public Exp visit(BlockStatement b) {
		var size = b.getStatements().getStatements().size();
		ExpAbstract expBlock = new CONST(0);

		for (int i = 0; i < size; i++) {
			var expr = new EXP(b.getStatements().getStatements().get(i).accept(this).unEx());

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
		currentClassTable = mainTable.getMap().get(m.getClassName().getS());
		currentMethodTable = currentClassTable.getMethodsContext().get("main");

		Stm stmBody = new EXP(new CONST(0));
		var stmList = new ArrayList<Stm>();
		var escapeList = new ArrayList<Boolean>();
		escapeList.add(false);
		frame = frame.newFrame("main", escapeList);

		var size = m.getStatements().getStatements().size();
		for (int i = 0; i < size; i++) {
			stmBody = new SEQ(
				stmBody,
				new EXP(
					m.getStatements().getStatements().get(i).accept(this).unEx()
				)
			);
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
		currentClassTable = mainTable.getMap().get(c.getClassName().getS());

		c.getClassName().accept(this);

		c.getFields().getVarDecls().forEach(field -> field.accept(this));
		c.getMethods().getMethodDecls().forEach(method -> method.accept(this));

		currentClassTable = null;
		return null;
	}

	public Exp visit(ClassDeclExtends c) {
		currentClassTable = mainTable.getMap().get(c.getClassName().getS());

		c.getClassName().accept(this);
		c.getParent().accept(this);

		c.getMethods().getMethodDecls().forEach(method -> method.accept(this));
		c.getFields().getVarDecls().forEach(field -> field.accept(this));

		currentClassTable = null;
		return null;
	}

	public Exp visit(Program p) {
		p.getMainClass().accept(this);
		p.getClasses().getClassDecls().forEach(classDecl -> classDecl.accept(this));
		return null;
	}

	public Exp visit(MethodDecl m) {
		currentMethodTable = currentClassTable.getMethodsContext().get(m.getIdentifier());

		Stm stmBody = new EXP(new CONST(0));
		var escapeList = new ArrayList<Boolean>();
		int sizeFormals = m.getFormals().getFormals().size();
		int sizeStatement = m.getStatements().getStatements().size();

		for (int i = 0; i <= sizeFormals; i++) {
			escapeList.add(false);
		}


		frame = frame.newFrame(
			currentClassTable.getClassName() + "$" + currentMethodTable.getMethodName(),
			escapeList
		);

		m.getFormals().getFormals().forEach(formal -> formal.accept(this));
		m.getVarDecls().getVarDecls().forEach(varDecl -> varDecl.accept(this));

		for (int i = 0; i < sizeStatement; i++) {
			stmBody = new SEQ(
				stmBody,
				new EXP(
					m.getStatements().getStatements().get(i).accept(this).unEx()
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

	public Exp visit(Formal f) {
		frame.allocLocal();
		return null;
	}

	public void addExp(ExpAbstract exp) {
		listExp.add(exp);
	}
}
