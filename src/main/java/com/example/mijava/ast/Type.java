package com.example.mijava.ast;

import com.example.mijava.visitor.ASTVisitor;


public abstract class Type extends ASTNode {
  
  public abstract <T> T accept(ASTVisitor<T> v);
  String name;
  
}