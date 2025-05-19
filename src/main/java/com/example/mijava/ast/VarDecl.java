package com.example.mijava.ast;

public class VarDecl extends ASTNode {
    private String className;
    private String argsName;
    private Statement statement; // Certifique-se de que a classe Statement existe e está importada.

    public VarDecl(String className, String argsName, Statement statement) {
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
        return visitor.visitVarDecl(this); // Certifique-se de que o método visitVarDecl existe no ASTVisitor.
    }
}