package com.example.mijava.ast;

import com.example.mijava.visitor.ASTVisitor;

public class ArrayAccessExpression extends Expression {
    public Expression array;
    public Expression index;

    public ArrayAccessExpression(Expression array, Expression index) {
        this.array = array;
        this.index = index;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}