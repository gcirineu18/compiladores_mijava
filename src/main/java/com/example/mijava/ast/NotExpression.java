package com.example.mijava.ast;

import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.visitor.ASTVisitor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class NotExpression extends Expression {
    
    private Expression e;

	public NotExpression(int line, int column){
			super(line, column);
	}

	@Override
	public String printNode() {
			return "Not ( " + e.printNode() + " ) ";
	}
	@Override
	public void createSymTab(SymTabScopeNode curScope) {}
	@Override
	public String typeCheck(SymTabScopeNode curScope) {
			if(!e.typeCheck(curScope).equals("BooleanType") && !e.typeCheck(curScope).equals("IntegerType")){
				semanticErrorNumber++;
				semanticErrorMsg.add(e.getTypeErr(semanticErrorNumber, "Type Error in Not Expression", "BooleanType or IntegerType", e.typeCheck(curScope)));
			}
			return "BooleanType";
	}

  @Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}
}
