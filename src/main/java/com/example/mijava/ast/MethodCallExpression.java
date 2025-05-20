package com.example.mijava.ast;

import com.example.mijava.visitor.ASTVisitor;

import java.util.List;

public class MethodCallExpression extends Expression {
    public Expression object;
    public Id methodName;
    public List<Expression> arguments;

    public MethodCallExpression(Expression object, Id methodName, List<Expression> arguments) {
        this.object = object;
        this.methodName = methodName;
        this.arguments = arguments;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}