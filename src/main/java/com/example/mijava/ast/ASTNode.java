package com.example.mijava.ast;

import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.visitor.ASTVisitor;

import java.util.List;

public abstract class ASTNode {

    public abstract void createSymTab(SymTabScopeNode escopoAtual);
    public abstract String typeCheck(SymTabScopeNode escopoAtual);

    public abstract <T> T accept(ASTVisitor<T> visitor);


    public static SymTabScopeNode mainScope;
    public static List<String> semanticErrorMsg;
    public static int semanticErrorNumber = 0;

    public static void PrintSymTabScope() {
        System.out.println("==========The Symbol Table Hierarchy==========");
        System.out.println(mainScope.getScopename());
        mainScope.printSymTab();
        for(SymTabScopeNode n : mainScope.next.values()){
            PrintSymTabScopeLoop(n);
        }
    }

    private static void PrintSymTabScopeLoop(SymTabScopeNode root) {
        System.out.println("\n" + root.getScopename());
        root.printSymTab();
        for(SymTabScopeNode n : root.next.values()){
            PrintSymTabScopeLoop(n);
        }
    }
}