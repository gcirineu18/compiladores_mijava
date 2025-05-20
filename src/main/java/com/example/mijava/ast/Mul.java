package com.example.mijava.ast;

import com.example.mijava.visitor.ASTVisitor;

public class Mul extends Expression {
  public Expression e1, e2;

  public Mul(Expression mul_e1, Expression mul_e2){
    this.e1 = mul_e1;
    this.e2 = mul_e2;
  }
  
  @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}