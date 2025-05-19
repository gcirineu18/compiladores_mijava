package com.example.mijava.ast;

public class PrintStatement extends ASTNode {


  @Override
  public <T> T accept(ASTVisitor<T> visitor) {
  return visitor.visit(this);
}
}

