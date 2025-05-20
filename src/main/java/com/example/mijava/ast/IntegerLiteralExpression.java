package com.example.mijava.ast;

import com.example.mijava.visitor.ASTVisitor;

public class IntegerLiteralExpression extends Expression {
    public int value;

    public IntegerLiteralExpression(int value) {
        this.value = value;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}