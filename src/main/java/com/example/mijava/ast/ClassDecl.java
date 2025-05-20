package com.example.mijava.ast;

import com.example.mijava.visitor.ASTVisitor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ClassDecl extends ASTNode {
    private Id id;

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}