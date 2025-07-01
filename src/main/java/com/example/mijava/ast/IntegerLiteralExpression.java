package com.example.mijava.ast;

import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.visitor.ASTVisitor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter 
public class IntegerLiteralExpression extends Expression {
    public int value;

    public IntegerLiteralExpression(int value, int line, int charpos) {
        super(line, charpos);
        this.value = value;
    }

    @Override
        public String printNode() {
            return "Integer Literal Expression:" + Integer.toString(value);
        }

    @Override
        public void createSymTab(SymTabScopeNode escopoAtual) {}

    @Override
    public String typeCheck(SymTabScopeNode escopoAtual) {
        return "IntegerType";
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}