package com.example.mijava.ast;

import com.example.mijava.visitor.ASTVisitor;

public class Id extends Expression{

  private String s;
  private int line, column;
  
  public Id(String str, int line, int column){
    this.s  = str;
    this.line = line;
    this.column = column
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) {
  return visitor.visit(this);
}

 @Override
 public String toString(){
  return this.s;
 } 
}
