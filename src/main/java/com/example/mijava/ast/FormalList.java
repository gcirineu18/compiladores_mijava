package com.example.mijava.ast;

import java.util.List;

import com.example.mijava.visitor.ASTVisitor;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FormalList extends ASTNode {
    private Type type;
    private Id identifier;
    private List<FormalRest> formalRest;

    public FormalList(Type type, Id identifier,List<FormalRest> formalRest ) {
        this.type = type;
        this.identifier = identifier;
        this.formalRest = formalRest;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}