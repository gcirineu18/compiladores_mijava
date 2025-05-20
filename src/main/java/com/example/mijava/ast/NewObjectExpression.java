package com.example.mijava.ast;

import com.example.mijava.visitor.ASTVisitor;

public class NewObjectExpression extends Expression {
    
    private Id id;

	NewObjectExpression(){};
	
    @Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}
}
