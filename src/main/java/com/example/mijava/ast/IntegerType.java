package com.example.mijava.ast;

import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.visitor.ASTVisitor;

public class IntegerType extends Type {

    public IntegerType(){
        this.name = "IntegerType";
    }
    @Override
    public void createSymTab(SymTabScopeNode curScope) {
    }

    @Override
    public String typeCheck(SymTabScopeNode curScope) {
        return printNode();
    }

    @Override
    public String printNode() {
        return "IntegerType";
    }

  @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
