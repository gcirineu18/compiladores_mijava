package com.example.mijava.ast;

import com.example.mijava.visitor.ASTVisitor;

public class NewArrayExpression extends Expression {
    private Expression e;

    public NewArrayExpression(Expression e) {
		this.e = e;
	}

    @Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}
}
