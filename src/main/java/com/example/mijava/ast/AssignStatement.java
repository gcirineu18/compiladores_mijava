package com.example.mijava.ast;

import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.visitor.ASTVisitor;

public class AssignStatement extends Statement{
  public Id id;
  public Expression expression;

  public AssignStatement(Id ai, Expression exp) {
    this.id = ai;
    this.expression = exp;
  }

  @Override
  public void createSymTab(SymTabScopeNode escopoAtual) {
    id.createSymTab(escopoAtual);
    expression.createSymTab(escopoAtual);
  }

  @Override
  public String typeCheck(SymTabScopeNode escopoAtual) {
    String idType = id.typeCheck(escopoAtual);
    String expressionType = expression.typeCheck(escopoAtual);

    if (!idType.equals(expressionType)) {
      throw new RuntimeException("Erro de tipo na atribuição: esperado " + idType + ", mas foi fornecido " + expressionType);
    }

    return "void";
  }

  @Override
  public String printNode() {
    return id.printNode() + " = " + expression.printNode() + ";";
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) {
    return visitor.visit(this);
  }
}