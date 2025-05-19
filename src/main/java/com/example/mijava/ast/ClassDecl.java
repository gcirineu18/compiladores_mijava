package com.example.mijava.ast;

import java.util.List;

public class ClassDecl extends ASTNode {
    private String id;
    private String superClass; // Optional superclass
    private List<VarDecl> varDecls;
    private List<MethodDecl> methodDecls;

    public ClassDecl(String id, String superClass, List<VarDecl> varDecls, List<MethodDecl> methodDecls) {
        this.id = id;
        this.superClass = superClass;
        this.varDecls = varDecls;
        this.methodDecls = methodDecls;
    }

    public String getId() {
        return id;
    }

    public String getSuperClass() {
        return superClass;
    }

    public List<VarDecl> getVarDecls() {
        return varDecls;
    }

    public List<MethodDecl> getMethodDecls() {
        return methodDecls;
    }

    @Override
    public <T> T  accept(ASTVisitor<T> visitor){
        return visitor.visit(this);
    }
}