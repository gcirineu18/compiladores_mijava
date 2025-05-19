package com.example.mijava.ast;

public class IfStatement extends Statement {
    private Expression condition;
    private Statement thenStatement;
    private Statement elseStatement;

    public IfStatement(Expression condition, Statement thenStatement, Statement elseStatement) {
        this.condition = condition;
        this.thenStatement = thenStatement;
        this.elseStatement = elseStatement;
    }

    public Expression getCondition() {
        return condition;
    }

    public Statement getThenStatement() {
        return thenStatement;
    }

    public Statement getElseStatement() {
        return elseStatement;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}