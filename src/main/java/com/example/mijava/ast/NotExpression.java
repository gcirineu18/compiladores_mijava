package com.example.mijava.ast;

import com.example.mijava.visitor.ASTVisitor;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NotExpression extends ASTNode {
    
    private Expression e;

  @Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}
}
