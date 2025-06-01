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
    public void createSymTab(SymTabScopeNode escopoAtual) {
        body.createSymTab(escopoAtual);
    }

    @Override
    public String typeCheck(SymTabScopeNode escopoAtual) {
        if (!condition.typeCheck(escopoAtual).equals("BooleanType")){
            semanticErrorNumber++;
            semanticErrorMsg.add(condition.getTypeErr(semanticErrorNumber, "Type error in While Statement", 
            "BooleanType", condition.typeCheck(escopoAtual)));
        }
        body.typeCheck(escopoAtual);
        return "null";
    }

    @Override
    public String printNode() {
        return "while (" + condition.printNode() + ") " + body.printNode();
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}