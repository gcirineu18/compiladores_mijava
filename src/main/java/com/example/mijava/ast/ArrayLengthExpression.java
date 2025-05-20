package com.example.mijava.ast;

import com.example.mijava.visitor.ASTVisitor;

public class ArrayLengthExpression extends Expression {
    public Expression array;

    public ArrayLengthExpression(Expression array) {
        this.array = array;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}