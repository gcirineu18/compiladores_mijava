package com.example.mijava.ast;

public abstract class ASTNode {
    
    protected int line;
    protected int column;

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}