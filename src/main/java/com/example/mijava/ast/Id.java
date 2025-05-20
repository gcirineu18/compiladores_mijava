package com.example.mijava.ast;

public class Id extends ASTNode{

  private String s;
  
  public Id(String str){
    this.s  = str;
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
