package com.example.mijava.ast;

public class And extends Expression {
   public Expression e1, e2;

   public And(Expression ae1, Expression ae2) {
      this.e1 = ae1;
      this.e2 = ae2;  
   }

   @Override
   public <T> T  accept(ASTVisitor<T> v){
        return v.visit(this);
   }

   
}