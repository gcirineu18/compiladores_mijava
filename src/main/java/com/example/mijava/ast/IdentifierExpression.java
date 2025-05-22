package com.example.mijava.ast;

import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.visitor.ASTVisitor;

public class IdentifierExpression extends Expression{

  String s;

  public IdentifierExpression(String str, int line, int charPositionInLine){
       super(line,charPositionInLine);
       this.s = str;
       this.name = str;
  }


  @Override
  public String printNode() {
      return "Expression ( " + "Identifier:" + s + " ) ";
  }

  @Override
  public void createSymTab(SymTabScopeNode escopoAtual) {}

  @Override
  public String typeCheck(SymTabScopeNode escopoAtual) {
      return new Id(s, line, charpos).typeCheck(escopoAtual);
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) {
    return visitor.visit(this);
  }
}