package com.example.mijava.ast;

import com.example.mijava.visitor.ASTVisitor;
import com.example.mijava.symbol.SymTabScopeNode;

public class BooleanType extends Type{

    public BooleanType(){
        this.name = "BooleanType";
    }

    @Override
    public void createSymTab(SymTabScopeNode escopoatual) {
    }

    @Override
    public String typeCheck(SymTabScopeNode escopoatual) {
        return printNode();
    }

    @Override
    public String printNode() {
        return "BooleanType";
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {       
        return visitor.visit(this);
    }
}
