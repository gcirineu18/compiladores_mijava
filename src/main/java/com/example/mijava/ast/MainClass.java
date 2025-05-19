package com.example.mijava.ast;

public class MainClass extends ASTNode {
    private String className;
    private String argsName;
    private Statement statement;

    public MainClass(String className, String argsName, Statement statement) {
        this.className = className;
        this.argsName = argsName;
        this.statement = statement;
    }

    // Getters
    public String getClassName() {
        return className;
    }

    public String getArgsName() {
        return argsName;
    }

    public Statement getStatement() {
        return statement;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}