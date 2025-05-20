package com.example.mijava.ast;

import com.example.mijava.visitor.ASTVisitor;

public abstract class Expression {
    public abstract <T> T accept(ASTVisitor<T> visitor);
}

