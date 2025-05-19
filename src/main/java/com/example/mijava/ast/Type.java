package com.example.mijava.ast;

public abstract class Type extends ASTNode{
  public abstract void accept(Visitor v);
  public abstract Type accept(TypeVisitor v);
  
}