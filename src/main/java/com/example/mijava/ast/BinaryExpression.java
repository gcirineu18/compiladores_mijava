package com.example.mijava.ast;

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
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
  
}
