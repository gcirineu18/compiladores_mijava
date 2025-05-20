package com.example.mijava.ast;

import com.example.mijava.visitor.ASTVisitor;

public class IdentifierExpression extends Expression{
  public String s;

  public IdentifierExpression(String ie) {
    this.s = ie;
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) {
    return visitor.visit(this);
  }
}