package com.example.mijava.ast;

import java.util.List;

import com.example.mijava.visitor.ASTVisitor;

public class ClassDeclSimple extends ClassDecl {
  public Id id;
  public List<VarDecl> varDeclList;
  public List<MethodDecl> methodDeclList;

  public ClassDeclSimple(Id a_id, List<VarDecl> a_vdl, List<MethodDecl> a_mdl){
    this.id = a_id;
    this.varDeclList = a_vdl;
    this.methodDeclList = a_mdl;
  }

  @Override
  public String printNode()


  
  @Override
  public <T> T accept(ASTVisitor<T> visitor) {
    return visitor.visit(this);
  }
  
}