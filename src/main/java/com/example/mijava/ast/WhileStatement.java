package com.example.mijava.ast;

import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.visitor.ASTVisitor;

public class WhileStatement extends Statement {
    private Expression condition;
    private Statement body;

    public WhileStatement(Expression condition, Statement body) {
        this.condition = condition;
        this.body = body;
    }

    public Expression getCondition() {
        return condition;
    }

    public Statement getBody() {
        return body;
    }

    @Override
    public String printNode() {
        return "while (" + condition.printNode() + ") " + body.printNode();
    }

    @Override
    public void createSymTab(SymTabScopeNode escopoAtual) {
        condition.createSymTab(escopoAtual);
        body.createSymTab(escopoAtual);
    }

    @Override
    public String typeCheck(SymTabScopeNode escopoAtual) {
        String conditionType = condition.typeCheck(escopoAtual);
        if (!conditionType.equals("boolean")) {
            throw new RuntimeException("Erro: A condição do while deve ser do tipo boolean, mas é " + conditionType);
        }

        body.typeCheck(escopoAtual);

        return "void";
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}