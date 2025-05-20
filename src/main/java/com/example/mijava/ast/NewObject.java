package com.example.mijava.ast;

import com.example.mijava.visitor.ASTVisitor;

import lombok.Builder;


public class NewObject extends Expression {
    
    private Id id;

    @Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}
}
