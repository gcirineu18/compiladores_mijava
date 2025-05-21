package com.example.mijava.ast;

import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.visitor.ASTVisitor;

public class IdentifierType extends Type {
  public Id identifier;

  public IdentifierType(Id identifier){
    this.identifier = identifier;
  }

  @Override
  public void createSymTab(SymTabScopeNode curScope) {
  }

  @Override
  public String typeCheck(SymTabScopeNode curScope) {
    return identifier.getS();
  }

  @Override
  public String printNode() {
    return identifier.getS();
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) {
    return visitor.visit(this);
  }
}