package com.example.mijava.ast;

import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.visitor.ASTVisitor;

public class PrintStatement extends Statement {
  public Expression expression;

  public PrintStatement(Expression exp) {
    this.expression = exp;
  }

  @Override
  public String printNode() {
    return "System.out.println(" + expression.printNode() + ")";
  }

  @Override
  public void createSymTab(SymTabScopeNode escopoAtual) {
    expression.createSymTab(escopoAtual);
  }

  @Override
  public String typeCheck(SymTabScopeNode escopoAtual) {
    String expressionType = expression.typeCheck(escopoAtual);

    return "void";
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) {
    return visitor.visit(this);
  }
}

