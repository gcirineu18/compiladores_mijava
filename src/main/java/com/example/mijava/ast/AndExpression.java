package com.example.mijava.ast;

import com.example.mijava.visitor.ASTVisitor;

public class AndExpression extends Expression {
   public Expression e1, e2;

   public AndExpression(Expression ae1, Expression ae2) {
      this.e1 = ae1;
      this.e2 = ae2;  
   }

   @Override
   public <T> T  accept(ASTVisitor<T> v){
        return v.visit(this);
   }

   
}