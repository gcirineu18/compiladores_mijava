package com.example.mijava.ast;

import java.util.List;

import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.symbol.SymbolEntry;
import com.example.mijava.visitor.ASTVisitor;

public class ClassDeclSimple extends ClassDecl {
    public Id id;
    public List<VarDecl> varDeclList;
    public List<MethodDecl> methodDeclList;
    public SymTabScopeNode clsScope;

    public ClassDeclSimple(Id a_id, List<VarDecl> a_vdl, List<MethodDecl> a_mdl) {
        this.id = a_id;
        this.varDeclList = a_vdl;
        this.methodDeclList = a_mdl;
    }

    @Override
    public String printNode() {
        StringBuilder builder = new StringBuilder("ClassDeclSimple ( ");
        builder.append(id.printNode()).append(" , ");
        for (VarDecl varDecl : varDeclList) {
            builder.append(varDecl.printNode()).append(", ");
        }
        for (MethodDecl methodDecl : methodDeclList) {
            builder.append(methodDecl.printNode()).append(", ");
        }
        builder.delete(builder.length() - 3, builder.length());
        builder.append(" )");

        return builder.toString();
    }

    @Override
    public void createSymTab(SymTabScopeNode curScope) {
        SymbolEntry classDeclEntry = new SymbolEntry("class", "class");

        if (!curScope.insertSym(id.getS(), classDeclEntry)) {
            semanticErrorNumber++;
            semanticErrorMsg.add(id.Getsemanticerr(semanticErrorNumber, "Duplicate class Definition"));
        }

        clsScope = new SymTabScopeNode(id.getS(), curScope);

        curScope.next.put(id.getS(), clsScope);

        for (VarDecl varDecl : varDeclList) {
            varDecl.createSymTab(clsScope);
        }
        for (MethodDecl methodDecl : methodDeclList) {
            methodDecl.createSymTab(clsScope);
        }
    }

    @Override
    public String typeCheck(SymTabScopeNode curScope) {
        for (VarDecl v : varDeclList) {
            v.typeCheck(clsScope);
        }
        for (MethodDecl m : methodDeclList) {
            m.typeCheck(clsScope);
        }
        return "null";
    }


    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }

}