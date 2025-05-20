package com.example.mijava.ast;

import com.example.mijava.visitor.ASTVisitor;

public class Sub extends Expression {
  public Expression e1, e2;

  public Sub(Expression sub_e1, Expression sub_e2){
    this.e1 = sub_e1;
    this.e2 = sub_e2;
  }
  
  @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}