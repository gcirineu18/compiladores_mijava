package com.example.mijava.ast;

import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.visitor.ASTVisitor;

public class AndExpression extends Expression {
   public Expression e1, e2;

   public AndExpression(Expression ae1, Expression ae2) {
      this.e1 = ae1;
      this.e2 = ae2;  
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

      if (!type1.equals("BooleanType")) {
         throw new RuntimeException("Erro de tipo na expressão AND: o primeiro operando deve ser do tipo booleano, mas foi fornecido " + type1);
      }

      if (!type2.equals("BooleanType")) {
         throw new RuntimeException("Erro de tipo na expressão AND: o segundo operando deve ser do tipo booleano, mas foi fornecido " + type2);
      }

      return "BooleanType";
   }

   @Override
   public String printNode() {
      return "(" + e1.printNode() + " && " + e2.printNode() + ")";
   }

   @Override
   public <T> T  accept(ASTVisitor<T> v){
        return v.visit(this);
   }

   
}