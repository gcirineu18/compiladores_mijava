package com.example.mijava.ast;

import java.util.List;

import com.example.mijava.visitor.ASTVisitor;

public class ClassDeclExtends extends ClassDecl {
  public Id id1;
  public Id id2;
  public List<VarDecl> varDeclList;
  public List<MethodDecl> methodDeclList;

  public ClassDeclExtends(Id a_id1, Id a_id2,
                          List<VarDecl> a_vdl, List<MethodDecl> a_mdl){
    this.id1 = a_id1;
    this.id2 = a_id2;
    this.varDeclList = a_vdl;
    this.methodDeclList = a_mdl;
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) {
    return visitor.visit(this);
  }
  
}
