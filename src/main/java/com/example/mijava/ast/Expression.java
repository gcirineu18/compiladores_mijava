package com.example.mijava.ast;

public abstract class Expression{
    public abstract void accept(ASTVisitor v);
    public abstract Type accept(TypeVisitor v);
}

