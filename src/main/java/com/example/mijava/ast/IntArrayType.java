package com.example.mijava.ast;


import com.example.mijava.visitor.ASTVisitor;

public class IntArrayType extends Type {
  @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
