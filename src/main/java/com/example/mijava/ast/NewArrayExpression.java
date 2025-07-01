package com.example.mijava.ast;

import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.visitor.ASTVisitor;

public class NewArrayExpression extends Expression {
    public Expression e;

		NewArrayExpression(int line, int column){
			super(line,column);
	}

    public NewArrayExpression(Expression e) {
		this.e = e;
	}

	@Override
	public String printNode() {
			return "NewArray ( " + e.printNode() + " ) ";
	}
	@Override
	public void createSymTab(SymTabScopeNode curScope) {}

	@Override
	public String typeCheck(SymTabScopeNode curScope) {
			if(!e.typeCheck(curScope).equals("IntegerType")){
					semanticErrorNumber++;
					semanticErrorMsg.add(e.getTypeErr(semanticErrorNumber, "Type Error in New Array Expression", "IntegerType", e.typeCheck(curScope)));
			}
			return "IntArrayType";
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}
}
