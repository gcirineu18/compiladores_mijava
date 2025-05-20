package com.example.mijava.ast;

import com.example.mijava.visitor.ASTVisitor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class FormalRest extends ASTNode{

  private Type type;
  private Id identifier;

  @Override
  public <T> T accept(ASTVisitor<T> visitor) {
     return visitor.visit(this);
  }
  
}
