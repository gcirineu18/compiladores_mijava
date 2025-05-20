package com.example.mijava.ast;


import java.util.List;

import com.example.mijava.visitor.ASTVisitor;

public class Block extends Statement {
    

    private List<Statement> statements;

    public Block(List<Statement> stst){
        this.statements = stst;
    }

     @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this); 
    }
}
