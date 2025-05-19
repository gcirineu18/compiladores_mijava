package com.example.mijava.ast;

public class Id extends ASTNode{
  private String s;
  
  @Override
  public <T> T accept(ASTVisitor<T> visitor) {
  return visitor.visit(this);
}
}
