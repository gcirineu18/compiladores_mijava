package com.example.mijava.ast;

import java.util.List;

import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.visitor.ASTVisitor;

public class BlockStatement extends Statement {

    private List<Statement> statements;
    private SymTabScopeNode blockScope;

    public BlockStatement(List<Statement> stst){
        this.statements = stst;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    public SymTabScopeNode getBlockScope() {
        return blockScope;
    }

    @Override
    public void createSymTab(SymTabScopeNode curScope) {
        blockScope = new SymTabScopeNode("#", curScope);
        curScope.next.put("#", blockScope);
        for (Statement s : statements) {
            s.createSymTab(blockScope);
        }
    }

    @Override
    public String typeCheck(SymTabScopeNode curScope) {
        for (Statement s : statements) {
            s.typeCheck(blockScope);
        }
        return "null";
    }

    @Override
    public String printNode() {
        StringBuilder result = new StringBuilder("{\n");
        for (Statement s : statements) {
            result.append("    ").append(s.printNode()).append(";\n");
        }
        result.append("}");
        return result.toString();
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }

}