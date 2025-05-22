package com.example.mijava.ast;

import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.visitor.ASTVisitor;

public class IdentifierType extends Type {
  public String identifier;

  public IdentifierType(String identifier){
    this.identifier = identifier;
    this.name = identifier;
  }

  @Override
  public void createSymTab(SymTabScopeNode curScope) {
  }

  @Override
  public String typeCheck(SymTabScopeNode curScope) {
    return printNode();
  }

  @Override
  public String printNode() {
    return "IdentifierType"; 
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) {
    return visitor.visit(this);
  }
}