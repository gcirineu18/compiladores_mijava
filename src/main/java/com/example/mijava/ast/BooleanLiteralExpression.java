package com.example.mijava.ast;

import com.example.mijava.visitor.ASTVisitor;

public class BooleanLiteralExpression extends Expression {
    public boolean value;

    public BooleanLiteralExpression(boolean value) {
        this.value = value;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}