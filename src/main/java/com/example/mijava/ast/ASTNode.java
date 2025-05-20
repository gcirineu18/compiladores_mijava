package com.example.mijava.ast;

import com.example.mijava.visitor.ASTVisitor;

public abstract class ASTNode {
    
    protected int line;
    protected int column;
    
    public abstract <T> T accept(ASTVisitor<T> visitor);
      
}