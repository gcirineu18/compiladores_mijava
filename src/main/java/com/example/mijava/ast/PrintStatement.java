package com.example.mijava.ast;

import com.example.mijava.visitor.ASTVisitor;

public class PrintStatement extends Statement {
  public Expression expression;

  public PrintStatement(Expression exp) {
    this.expression = exp;
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) {
    return visitor.visit(this);
  }
}

