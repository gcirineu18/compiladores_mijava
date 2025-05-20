package com.example.mijava.ast;

import com.example.mijava.visitor.ASTVisitor;

public abstract class Expression extends ASTNode{
  public abstract <T> T accept(ASTVisitor<T> v); 
}

