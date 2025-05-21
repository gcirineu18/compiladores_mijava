package com.example.mijava.ast;

import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.visitor.ASTVisitor;

public class FalseExpression extends Expression {
  
  public FalseExpression(int line, int column){
    super(line, column);
  }

  @Override
  public String printNode() {
      return "False Expression";
  }

  @Override
  public void createSymTab(SymTabScopeNode escopoAtual) {}

  @Override
  public String typeCheck(SymTabScopeNode escopoAtual) {
      return "BooleanType";
  }

  @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}