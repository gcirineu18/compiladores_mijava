package com.example.mijava.ast;

import com.example.mijava.visitor.ASTVisitor;

<<<<<<< HEAD
public abstract class Expression{
  public abstract <T> T accept(ASTVisitor<T> v); 
=======
public abstract class Expression {
    public abstract <T> T accept(ASTVisitor<T> visitor);
>>>>>>> c071acb2c8d74dc424c7f35c2376880ea1674502
}

