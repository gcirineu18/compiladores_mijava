package com.example.mijava.ast;

import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.visitor.ASTVisitor;

public class IntegerType extends Type {

    @Override
    public void createSymTab(SymTabScopeNode curScope) {
    }

    @Override
    public String typeCheck(SymTabScopeNode curScope) {
        return "IntegerType";
    }

    @Override
    public String printNode() {
        return "int";
    }

  @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
