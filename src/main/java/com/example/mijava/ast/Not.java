package com.example.mijava.ast;

import com.example.mijava.visitor.ASTVisitor;

public class Not extends ASTNode {
    
    private Expression e;

    @Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}
}
