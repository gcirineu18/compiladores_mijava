package com.example.mijava.ast;

import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.visitor.ASTVisitor;

public class LessThan extends BinaryExpression {
  

  public LessThan(int line, int charpos){
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
      throw new RuntimeException("Erro de tipo na expressão LessThan (<): o primeiro operando deve ser do tipo inteiro, mas foi fornecido " + type1);
    }

    if (!type2.equals("IntegerType")) {
      throw new RuntimeException("Erro de tipo na expressão LessThan (<): o segundo operando deve ser do tipo inteiro, mas foi fornecido " + type2);
    }

    return "BooleanType";
  }

  @Override
  public String printNode() {
    return "(" + left.printNode() + " < " + right.printNode() + ")";
  }

  @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
