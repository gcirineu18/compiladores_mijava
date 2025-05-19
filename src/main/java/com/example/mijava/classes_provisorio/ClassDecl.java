package com.example.mijava.classes_provisorio;
import visitor.Visitor;
import visitor.TypeVisitor;

public abstract class ClassDecl {
  public abstract void accept(Visitor v);
  public abstract Type accept(TypeVisitor v);
}
