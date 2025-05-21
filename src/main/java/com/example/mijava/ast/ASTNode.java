package com.example.mijava.ast;

import com.example.mijava.visitor.ASTVisitor;

public abstract class ASTNode {

    public abstract void createSymTab(SymTabScopeNode escopoAtual);
    public abstract String typeCheck(SymTabScopeNode escopoAtual);

    public abstract <T> T accept(ASTVisitor<T> visitor);
      
}