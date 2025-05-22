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
    public void createSymTab(SymTabScopeNode escopoAtual) {
        thenStatement.createSymTab(escopoAtual);
        elseStatement.createSymTab(escopoAtual);
        
    }

    @Override
    public String typeCheck(SymTabScopeNode escopoAtual) {
        String conditionType = condition.typeCheck(escopoAtual);

        if (!conditionType.equals("BooleanType")) {
            semanticErrorNumber++;
            semanticErrorMsg.add(condition.getTypeErr(semanticErrorNumber, "Type error in If Statement", 
            "BooleanType", condition.typeCheck(escopoAtual)));
        }

        thenStatement.typeCheck(escopoAtual);
        elseStatement.typeCheck(escopoAtual);
    
        return "null";
    }

    @Override
    public String printNode() {
        return "If ( " + condition.printNode() + " , " + thenStatement.printNode() + " , " + elseStatement.printNode() + " ) ";
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}