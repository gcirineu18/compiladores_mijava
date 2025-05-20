package com.example.mijava.ast;

import com.example.mijava.visitor.ASTVisitor;

public class ThisExpression extends Expression{
    @Override
     public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
     }
}