package com.example.mijava.ast;

import com.example.mijava.visitor.ASTVisitor;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VarDecl extends ASTNode {
    private Id Identifier;
    private Type type;


    public VarDecl(Id id, Type type) {
        this.Identifier = id;
        this.type = type;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this); 
    }
}