package com.example.mijava.ast;

import com.example.mijava.visitor.ASTVisitor;

public abstract class ASTNode {
    
    protected int line;
    protected int column;
    
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
     }
}