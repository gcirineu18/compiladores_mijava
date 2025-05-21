package com.example.mijava.ast;

import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.visitor.ASTVisitor;

public class ArrayAssignStatement extends Statement {
  public Id i;
  public Expression e1, e2;

  public ArrayAssignStatement(Id ai, Expression ae1, Expression ae2) {
    this.i = ai;
    this.e1 = ae1;
    this.e2 = ae2;
  }

  @Override
  public String printNode() {
    return i.printNode() + "[" + e1.printNode() + "] = " + e2.printNode() + ";";
  }

  @Override
  public void createSymTab(SymTabScopeNode escopoAtual) {
    i.createSymTab(escopoAtual);
    e1.createSymTab(escopoAtual);
    e2.createSymTab(escopoAtual);
  }

  @Override
  public String typeCheck(SymTabScopeNode escopoAtual) {
    String idType = i.typeCheck(escopoAtual);

    if (!idType.equals("IntArrayType")) {
      throw new RuntimeException("Erro de tipo: esperado um array, mas foi fornecido " + idType);
    }

    String indexType = e1.typeCheck(escopoAtual);
    if (!indexType.equals("IntegerType")) {
      throw new RuntimeException("Erro de tipo: índice do array deve ser inteiro, mas foi fornecido " + indexType);
    }

    String valueType = e2.typeCheck(escopoAtual);
    if (!valueType.equals("IntegerType")) {
      throw new RuntimeException("Erro de tipo: valor atribuído ao array deve ser inteiro, mas foi fornecido " + valueType);
    }

    return "void";
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) {
    return visitor.visit(this);
  }
}