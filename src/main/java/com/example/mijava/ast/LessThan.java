package com.example.mijava.ast;

import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.visitor.ASTVisitor;

public class LessThan extends Expression {
  public Expression e1, e2;

  public LessThan(Expression lt_e1, Expression lt_e2){
    this.e1 = lt_e1;
    this.e2 = lt_e2;
  }

  @Override
  public void createSymTab(SymTabScopeNode escopoAtual) {
    e1.createSymTab(escopoAtual);
    e2.createSymTab(escopoAtual);
  }

  @Override
  public String typeCheck(SymTabScopeNode escopoAtual) {
    String type1 = e1.typeCheck(escopoAtual);
    String type2 = e2.typeCheck(escopoAtual);

    if (!type1.equals("IntegerType")) {
      throw new RuntimeException("Erro de tipo na expressão LessThan (<): o primeiro operando deve ser do tipo inteiro, mas foi fornecido " + type1);
    }

    if (!type2.equals("IntegerType")) {
      throw new RuntimeException("Erro de tipo na expressão LessThan (<): o segundo operando deve ser do tipo inteiro, mas foi fornecido " + type2);
    }

    return "BooleanType";
  }

  @Override
  public String printNode() {
    return "(" + e1.printNode() + " < " + e2.printNode() + ")";
  }

  @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
