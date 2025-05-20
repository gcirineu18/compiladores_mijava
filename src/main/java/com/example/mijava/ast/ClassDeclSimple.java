package com.example.mijava.ast;

import com.example.mijava.visitor.ASTVisitor;

public class ClassDeclSimple extends ClassDecl {
  public Id i;
  public VarDeclList vl;
  public MethodDeclList ml;

  public ClassDeclSimple(Id ai, VarDeclList avl, MethodDeclList aml){
    this.i = ai;
    this.vl = avl;
    this.ml = aml;
  }
  
  @Override
  public <T> T accept(ASTVisitor<T> visitor) {
    return visitor.visit(this);
  }
  
}