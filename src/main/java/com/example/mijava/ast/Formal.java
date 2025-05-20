package com.example.mijava.ast;

import com.example.mijava.visitor.ASTVisitor;

public class Formal extends ASTNode {
    private Type type;
    private String name;

    public Formal(Type type, String name) {
        this.type = type;
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}