package com.example.mijava.ast;

import java.util.List;

import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.visitor.ASTVisitor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
    public String printNode(){
        StringBuilder builder  = new StringBuilder("Program ( ");
        builder.append(mainClass.toString());
        for (ClassDecl classDecl : classes) {
            builder.append(classDecl.printNode()).append(" , ");
        }
        builder.delete(builder.length() - 3, builder.length());
        builder.append(" )");
        return builder.toString();
    }

    @Override
    public void createSymTab(SymTabScopeNode curScope) {
        mainClass.createSymTab(curScope);
        for (ClassDecl classDecl : classes) {
            classDecl.createSymTab(curScope);
        }
    }



    @Override
    public String typeCheck(SymTabScopeNode escopoAtual) {
        mainClass.typeCheck(mainScope.next.get(mainClass.getClassName().getS()));
        for (ClassDecl classDecl : classes) {
            classDecl.typeCheck(mainScope.next.get(classDecl.getId().getS()));
        }
        return  null;
    }


    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
}

}