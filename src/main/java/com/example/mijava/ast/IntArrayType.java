package com.example.mijava.ast;

import com.example.mijava.visitor.ASTVisitor;
import com.example.mijava.symbol.SymTabScopeNode;

public class IntArrayType extends Type {
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
    public IntArrayType(){
      this.name = "IntArrayType";
    }

    @Override
    public void createSymTab(SymTabScopeNode escopoatual) {
    }

    @Override
    public String typeCheck(SymTabScopeNode escopoAtual) {
        return printNode();
    }

    @Override
    public String printNode() {
        return "IntArrayType";
    }
}