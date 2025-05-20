package com.example.mijava.ast;

import com.example.mijava.visitor.ASTVisitor;

public class IdentifierType extends Type {
  public String s;

  public IdentifierType(String it){
    this.s = it;
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) {
    return visitor.visit(this);
  }
}