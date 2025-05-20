package com.example.mijava.ast;

import com.example.mijava.visitor.ASTVisitor;

public abstract class Statement extends ASTNode{
     public abstract <T> T accept(ASTVisitor<T> v); 
}
