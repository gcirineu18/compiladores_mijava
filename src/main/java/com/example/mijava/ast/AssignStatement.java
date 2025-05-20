package com.example.mijava.ast;

import com.example.mijava.visitor.ASTVisitor;

public class AssignStatement extends Statement{
  public Id id;
  public Expression expression;

  public AssignStatement(Id ai, Expression exp) {
    this.id = ai;
    this.expression = exp;
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) {
    return visitor.visit(this);
  }
}