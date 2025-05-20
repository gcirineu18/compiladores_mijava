package com.example.mijava.ast;

import com.example.mijava.visitor.ASTVisitor;

public abstract class ASTNode {
    
    protected int line;
    protected int column;
<<<<<<< HEAD
    
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
     }
=======

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
>>>>>>> c071acb2c8d74dc424c7f35c2376880ea1674502
}