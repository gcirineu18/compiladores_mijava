package com.example.mijava.ast;

import java.util.List;

public class Program extends ASTNode {
    private MainClass mainClass;
    private List<ClassDecl> classes;

    public Program(MainClass mainClass, List<ClassDecl> classes) {
        this.mainClass = mainClass;
        this.classes = classes;
    }

    public MainClass getMainClass() { return mainClass; }
    public List<ClassDecl> getClasses() { return classes; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
}

}