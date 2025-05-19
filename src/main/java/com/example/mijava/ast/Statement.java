package com.example.mijava.ast;

public abstract class Statement extends ASTNode{
    public abstract void accept(ASTVisitor v);
    public abstract Type accept(TypeVisitor v);

}
