package com.example.mijava.ast;

import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.visitor.ASTVisitor;

public class ArrayLengthExpression extends Expression {
    public Expression array;

    public ArrayLengthExpression(Expression array) {
        this.array = array;
    }

    @Override
    public void createSymTab(SymTabScopeNode escopoAtual) {
        array.createSymTab(escopoAtual);
    }

    @Override
    public String typeCheck(SymTabScopeNode escopoAtual) {
        String arrayType = array.typeCheck(escopoAtual);

        if (!arrayType.equals("IntArrayType")) {
            throw new RuntimeException("Erro de tipo na expressão ArrayLength: a expressão deve ser do tipo array, mas foi fornecido " + arrayType);
        }

        return "IntegerType";
    }

    @Override
    public String printNode() {
        return array.printNode() + ".length";
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}