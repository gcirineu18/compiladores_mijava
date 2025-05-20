package com.example.mijava.ast;

import java.util.List;

import com.example.mijava.visitor.ASTVisitor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassDecl extends ASTNode {
    private Id id;
    private Id superClass; // Optional superclass
    private List<VarDecl> varDecls;
    private List<MethodDecl> methodDecls;

    public ClassDecl(Id id, Id superClass, List<VarDecl> varDecls, List<MethodDecl> methodDecls) {
        this.id = id;
        this.superClass = superClass;
        this.varDecls = varDecls;
        this.methodDecls = methodDecls;
    }

    public ClassDecl() {}

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}