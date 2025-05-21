package com.example.mijava.ast;

import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.visitor.ASTVisitor;

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
    public String printNode() {
        StringBuilder result = new StringBuilder();
        result.append("if (").append(condition.printNode()).append(") ");
        result.append(thenStatement.printNode());

        if (elseStatement != null) {
            result.append(" else ").append(elseStatement.printNode());
        }

        return result.toString();
    }

    @Override
    public void createSymTab(SymTabScopeNode escopoAtual) {
        condition.createSymTab(escopoAtual);
        thenStatement.createSymTab(escopoAtual);

        if (elseStatement != null) {
            elseStatement.createSymTab(escopoAtual);
        }
    }

    @Override
    public String typeCheck(SymTabScopeNode escopoAtual) {
        String conditionType = condition.typeCheck(escopoAtual);
        if (!conditionType.equals("boolean")) {
            throw new RuntimeException("Erro: A condição do if deve ser do tipo boolean, mas é " + conditionType);
        }

        thenStatement.typeCheck(escopoAtual);

        if (elseStatement != null) {
            elseStatement.typeCheck(escopoAtual);
        }

        return "void";
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}