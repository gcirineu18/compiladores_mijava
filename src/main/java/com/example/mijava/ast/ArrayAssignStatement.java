package com.example.mijava.ast;

import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.visitor.ASTVisitor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArrayAssignStatement extends Statement {
  public Id i;
  public Expression e1, e2;

  public ArrayAssignStatement(Id ai, Expression ae1, Expression ae2) {
    this.i = ai;
    this.e1 = ae1;
    this.e2 = ae2;
  }

  @Override
  public void createSymTab(SymTabScopeNode escopoAtual) {
  }

  @Override
  public String typeCheck(SymTabScopeNode escopoAtual) {
    String idType = i.typeCheck(escopoAtual);

    if (!idType.equals("IntArrayType")) {
      semanticErrorNumber++;
      semanticErrorMsg.add(i.getTypeErr(semanticErrorNumber, "Type Error in Assign Array statement", "IntArrayType", i.typeCheck(escopoAtual)));
    }

    String indexType = e1.typeCheck(escopoAtual);
    if (!indexType.equals("IntegerType")) {
      semanticErrorNumber++;
      semanticErrorMsg.add(e1.getTypeErr(semanticErrorNumber, "Type Error in Assign Array statement", "IntegerType", e1.typeCheck(escopoAtual)));
    }

    String valueType = e2.typeCheck(escopoAtual);
    if (!valueType.equals("IntegerType")) {
      semanticErrorNumber++;
      semanticErrorMsg.add(e2.getTypeErr(semanticErrorNumber, "Type Error in Assign Array statement", "IntegerType", e2.typeCheck(escopoAtual)));
    }
    return "null";
  }

  @Override
  public String printNode() {
    return i.printNode() + "[" + e1.printNode() + "] = " + e2.printNode() + ";";
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) {
    return visitor.visit(this);
  }
}