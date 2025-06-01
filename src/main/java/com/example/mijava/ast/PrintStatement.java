package com.example.mijava.ast;

import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.visitor.ASTVisitor;

public class PrintStatement extends Statement {
  public Expression expression;

  public PrintStatement(Expression exp) {
    this.expression = exp;
  }


  @Override
  public void createSymTab(SymTabScopeNode escopoAtual) {
    
  }

  @Override
  public String typeCheck(SymTabScopeNode escopoAtual) {
    if(!expression.typeCheck(escopoAtual).equals("IntegerType")){
          semanticErrorNumber++;
          semanticErrorMsg.add(expression.getTypeErr(semanticErrorNumber, 
          "Type Error in Print statement", "IntegerType", expression.typeCheck(escopoAtual)));
      };
      return "null";
  }

  @Override
  public String printNode() {
    return "System.out.println(" + expression.printNode() + ")";
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) {
    return visitor.visit(this);
  }
}

