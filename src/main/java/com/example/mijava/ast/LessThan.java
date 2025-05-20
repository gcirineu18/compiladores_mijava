package com.example.mijava.ast;

import com.example.mijava.visitor.ASTVisitor;

public class LessThan extends Expression {
  public Expression e1, e2;

  public LessThan(Expression lt_e1, Expression lt_e2){
    this.e1 = lt_e1;
    this.e2 = lt_e2;
  }

  @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
