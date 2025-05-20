package com.example.mijava.ast;

public class ArrayAssignStatement extends Statement {
  public Id i;
  public Expression e1, e2;

  public ArrayAssignStatement(Id ai, Expression ae1, Expression ae2) {
    this.i = ai;
    this.e1 = ae1;
    this.e2 = ae2;
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) {
    return visitor.visit(this);
  }
}