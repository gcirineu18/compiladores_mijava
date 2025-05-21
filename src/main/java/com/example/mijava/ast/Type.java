package com.example.mijava.ast;

import com.example.mijava.visitor.ASTVisitor;
import com.example.mijava.symbol.SymTabScopeNode;

public abstract class Type extends ASTNode {
  public abstract void createSymTab(SymTabScopeNode escopoatual);

  public abstract String typeCheck(SymTabScopeNode escopoatual);

  public abstract String printNode();

  public abstract <T> T accept(ASTVisitor<T> v);
  String name;
  
}