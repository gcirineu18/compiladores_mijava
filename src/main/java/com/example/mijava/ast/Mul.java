package com.example.mijava.ast;

import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.visitor.ASTVisitor;

public class Mul extends BinaryExpression {
  

  public Mul(int line, int charpos){
            super(line, charpos);
        }

  @Override
  public void createSymTab(SymTabScopeNode escopoAtual) {

  }

  @Override
  public String typeCheck(SymTabScopeNode escopoAtual) {
    String type1 = left.typeCheck(escopoAtual);
    String type2 = right.typeCheck(escopoAtual);

    if (!type1.equals("IntegerType")) {
       semanticErrorNumber++;
       semanticErrorMsg.add(left.getTypeErr(semanticErrorNumber, "Type Error in Binary Expression", "IntegerType", left.typeCheck(escopoAtual)));
    }

    if (!type2.equals("IntegerType")) {
       semanticErrorNumber++;
       semanticErrorMsg.add(right.getTypeErr(semanticErrorNumber, "Type Error in Binary Expression", "IntegerType", right.typeCheck(escopoAtual)));
    }

    return "IntegerType";
  }

  @Override
  public String printNode() {
    return "(" + left.printNode() + " * " + right.printNode() + ")";
  }
  
  @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}