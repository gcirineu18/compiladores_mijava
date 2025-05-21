package com.example.mijava.ast;

import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.visitor.ASTVisitor;

public class BinaryExpression extends Expression {
    public Expression left;
    public Expression right;
    public String operator;

    public BinaryExpression(Expression left, String operator, Expression right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    @Override
    public void createSymTab(SymTabScopeNode escopoAtual) {
        left.createSymTab(escopoAtual);
        right.createSymTab(escopoAtual);
    }

    @Override
    public String typeCheck(SymTabScopeNode escopoAtual) {
        String leftType = left.typeCheck(escopoAtual);
        String rightType = right.typeCheck(escopoAtual);

        switch (operator) {
            case "+":
            case "-":
            case "*":
                if (!leftType.equals("IntegerType") || !rightType.equals("IntegerType")) {
                    throw new RuntimeException("Erro de tipo em expressão binária: operandos devem ser do tipo inteiro para " + operator);
                }
                return "IntegerType";

            case "<":

                if (!leftType.equals("IntegerType") || !rightType.equals("IntegerType")) {
                    throw new RuntimeException("Erro de tipo em expressão binária: operandos devem ser do tipo inteiro para " + operator);
                }
                return "BooleanType";

            case "&&":
                if (!leftType.equals("BooleanType") || !rightType.equals("BooleanType")) {
                    throw new RuntimeException("Erro de tipo em expressão binária: operandos devem ser do tipo booleano para " + operator);
                }
                return "BooleanType";

            default:
                throw new RuntimeException("Operador binário não reconhecido: " + operator);
        }
    }

    @Override
    public String printNode() {
        return "(" + left.printNode() + " " + operator + " " + right.printNode() + ")";
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
  
}
