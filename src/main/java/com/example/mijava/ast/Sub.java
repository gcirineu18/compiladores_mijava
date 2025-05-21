package com.example.mijava.ast;

import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.visitor.ASTVisitor;

public class Sub extends BinaryExpression{
  

  public Sub(int line, int charpos){
            super(line, charpos);
        }

  @Override
  public void createSymTab(SymTabScopeNode escopoAtual) {
    left.createSymTab(escopoAtual);
    right.createSymTab(escopoAtual);
  }

  @Override
  public String typeCheck(SymTabScopeNode escopoAtual) {
    String type1 = left.typeCheck(escopoAtual);
    String type2 = right.typeCheck(escopoAtual);

    if (!type1.equals("IntegerType")) {
      throw new RuntimeException("Erro de tipo na expressão Sub (-): o primeiro operando deve ser do tipo inteiro, mas foi fornecido " + type1);
    }

    if (!type2.equals("IntegerType")) {
      throw new RuntimeException("Erro de tipo na expressão Sub (-): o segundo operando deve ser do tipo inteiro, mas foi fornecido " + type2);
    }

    return "IntegerType";
  }

  @Override
  public String printNode() {
    return "(" + left.printNode() + " - " + right.printNode() + ")";
  }
  
  @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}