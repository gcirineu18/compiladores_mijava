package com.example.mijava.ast;

import java.util.List;

import com.example.mijava.visitor.ASTVisitor;

public class MethodDecl extends ASTNode {
    private Type returnType;
    private String methodName;
    private List<Formal> parameters;
    private List<VarDecl> varDecls;
    private List<Statement> statements;
    private Expression returnExpression;

    public MethodDecl(Type returnType, String methodName, List<Formal> parameters,
                      List<VarDecl> varDecls, List<Statement> statements,
                      Expression returnExpression) {
        this.returnType = returnType;
        this.methodName = methodName;
        this.parameters = parameters;
        this.varDecls = varDecls;
        this.statements = statements;
        this.returnExpression = returnExpression;
    }

    // Getters
    public Type getReturnType() {
        return returnType;
    }

    public String getMethodName() {
        return methodName;
    }

    public List<Formal> getParameters() {
        return parameters;
    }

    public List<VarDecl> getVarDecls() {
        return varDecls;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    public Expression getReturnExpression() {
        return returnExpression;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}