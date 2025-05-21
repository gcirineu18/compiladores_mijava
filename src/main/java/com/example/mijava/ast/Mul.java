package com.example.mijava.ast;

import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.visitor.ASTVisitor;

public class Mul extends Expression {
  public Expression e1, e2;

  public Mul(Expression mul_e1, Expression mul_e2){
    this.e1 = mul_e1;
    this.e2 = mul_e2;
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
      throw new RuntimeException("Erro de tipo na expressão Mul (*): o primeiro operando deve ser do tipo inteiro, mas foi fornecido " + type1);
    }

    if (!type2.equals("IntegerType")) {
      throw new RuntimeException("Erro de tipo na expressão Mul (*): o segundo operando deve ser do tipo inteiro, mas foi fornecido " + type2);
    }

    return "IntegerType";
  }

  @Override
  public String printNode() {
    return "(" + e1.printNode() + " * " + e2.printNode() + ")";
  }
  
  @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}