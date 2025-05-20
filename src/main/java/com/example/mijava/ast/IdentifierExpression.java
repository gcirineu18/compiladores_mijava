package com.example.mijava.ast;

import com.example.mijava.visitor.ASTVisitor;

public class IdentifierExpression extends Expression{
  public Id id;

  public IdentifierExpression(Id id) {
    this.id = id;
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) {
    return visitor.visit(this);
  }
}