package com.example.mijava.mijava;

import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;

import com.example.mijava.antlr.MijavaLexer;
import com.example.mijava.antlr.MijavaParser;
import com.example.mijava.ast.ASTNode;
import com.example.mijava.canon.BasicBlocks;
import com.example.mijava.canon.Canon;
import com.example.mijava.canon.TraceSchedule;
import com.example.mijava.mips.MipsFrame;
import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.visitor.ASTBuilderVisitor;
import com.example.mijava.visitor.IRTree.IRTreeVisitor;
import com.example.mijava.visitor.IRTree.ProcFrag;

public class MijavaCompile {

    private ASTNode root;
    private SymTabScopeNode mainScope;
    private final MipsFrame frame = new MipsFrame();

    public void compile(String filePath) throws IOException {

      ParseTree tree = parsedTree(filePath);

      mainScope = buildAST(tree);

      buildIRTree();


    }

    private ParseTree parsedTree(String filePath) throws IOException {

        CharStream input = CharStreams.fromFileName(filePath);
        MijavaLexer lexer = new MijavaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MijavaParser parser = new MijavaParser(tokens);      
        ParseTree tree = parser.program();
        
         //System.out.println(tree.toStringTree(parser));
        return tree;

    }

    private SymTabScopeNode buildAST(ParseTree tree){
         ASTBuilderVisitor ASTvisitor = new ASTBuilderVisitor();
         root = ASTvisitor.visit(tree);
      // System.out.println(root.printNode());

         SymTabScopeNode globalScope = new SymTabScopeNode("global", null);

        root.createSymTab(globalScope);
        //ASTNode.printSymTabScope();

        root.typeCheck(globalScope);
        for( String erro: ASTNode.semanticErrorMsg){
            System.out.println(erro);    
        }
        
        return ASTNode.mainScope;
    }

    private void buildIRTree(){
        var frame = new MipsFrame();
        IRTreeVisitor irTree = new IRTreeVisitor(mainScope, frame);
        root.accept(irTree);

        //printIRTree(irTree);
        printCanonicalTree(irTree);
    }


    private static void printIRTree( IRTreeVisitor irTree){
        var frag = irTree.getInitialFrag().getNext();
       while (frag != null) {
       if (frag instanceof ProcFrag procFrag) {
               System.out.println("\n--- Método: " + procFrag.getFrame().name + " ---");
               System.out.println(procFrag.getBody()); 
       }
       frag = frag.getNext();
       }
    }

    private static void printCanonicalTree(IRTreeVisitor irTree){
        // Para percorrer todos os fragmentos e aplicar a canonização em cada um
        var currentFrag = irTree.getInitialFrag().getNext();
        System.out.println("\n>> Intermediate Canonical Code <<");

        while (currentFrag != null) {
            if (currentFrag instanceof ProcFrag procFrag) {
                System.out.println("\n--- Método: " + procFrag.getFrame().name + " ---");
                var canonIRTree = new TraceSchedule(new BasicBlocks(Canon.linearize(procFrag.getBody())));

                for (var i = canonIRTree.stms; i != null; i = i.tail) {
                    System.out.println(i.head);
                }
            }
            currentFrag = currentFrag.getNext();
        }

    }
    
}
