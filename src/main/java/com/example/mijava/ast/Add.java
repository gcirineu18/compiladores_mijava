package com.example.mijava.ast;

import com.example.mijava.visitor.ASTVisitor;

public class Add extends Expression {
  public Expression e1, e2;

  public Add(Expression add_e1, Expression add_e2){
    this.e1 = add_e1;
    this.e2 = add_e2;
  }

  @O

  @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}