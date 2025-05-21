package com.example.mijava.ast;

import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.visitor.ASTVisitor;

public class IdentifierExpression extends Expression{
  public Id id;

  String s;
  IdentifierExpression(String str, int line, int charPositionInLine){
       super(line,charPositionInLine);
       this.s = str;
       this.name = str;
  }

  public IdentifierExpression(Id id) {
    this.id = id;
  }

  @Override
  public String printNode() {
      return "Expression ( " + "Identifier:" + id + " ) ";
  }

  @Override
  public void createSymTab(SymTabScopeNode escopoAtual) {}

  @Override
  public String typeCheck(SymTabScopeNode escopoAtual) {
      return new IdentifierExpression(id).typeCheck(escopoAtual);
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) {
    return visitor.visit(this);
  }
}