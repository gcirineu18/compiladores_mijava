package com.example.mijava.ast;

import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.visitor.ASTVisitor;

public class TrueExpression extends Expression {
  TrueExpression(int line, int column){
    super(line, column);
}

  @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
  
  @Override
  public String printNode() {
      return "True Expression";
  }

  @Override
    public void createSymTab(SymTabScopeNode escopoAtual) {}

  @Override
  public String typeCheck(SymTabScopeNode escopoAtual) {
      return "BooleanType";
  }


}
