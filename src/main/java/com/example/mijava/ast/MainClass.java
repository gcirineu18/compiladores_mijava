package com.example.mijava.ast;

import com.example.mijava.visitor.ASTVisitor;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class MainClass extends ASTNode {
    private Id className;
    private Id argsName;
    private Statement statement;

    public MainClass(Id className, Id argsName, Statement statement) {
        this.className = className;
        this.argsName = argsName;
        this.statement = statement;
    }


    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}