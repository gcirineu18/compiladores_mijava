package com.example.mijava.ast;

import java.util.List;

import com.example.mijava.visitor.ASTVisitor;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MethodDecl extends ASTNode {
    private Type returnType;
    private Id methodName;
    private FormalList parameter;
    private List<VarDecl> varDecls;
    private List<Statement> statements;
    private Expression returnExpression;

    public MethodDecl(Type returnType, Id methodName, FormalList parameters,
                      List<VarDecl> varDecls, List<Statement> statements,
                      Expression returnExpression) {
        this.returnType = returnType;
        this.methodName = methodName;
        this.parameter = parameters;
        this.varDecls = varDecls;
        this.statements = statements;
        this.returnExpression = returnExpression;
    }

    // Getters
    public Type getReturnType() {
        return returnType;
    }

    public Id getMethodName() {
        return methodName;
    }

    public FormalList getParameters() {
        return parameter;
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