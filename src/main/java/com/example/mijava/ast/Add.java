package com.example.mijava.ast;

import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.visitor.ASTVisitor;

public class Add extends Expression {
  public Expression e1, e2;

  public Add(Expression add_e1, Expression add_e2){
    this.e1 = add_e1;
    this.e2 = add_e2;
  }

  @Override
  public String printNode() {
    return "(" + e1.printNode() + " + " + e2.printNode() + ")";
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
      throw new RuntimeException("Erro de tipo na expressão Add (+): o primeiro operando deve ser do tipo inteiro, mas foi fornecido " + type1);
    }

    if (!type2.equals("IntegerType")) {
      throw new RuntimeException("Erro de tipo na expressão Add (+): o segundo operando deve ser do tipo inteiro, mas foi fornecido " + type2);
    }

    return "IntegerType";
  }

  @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}