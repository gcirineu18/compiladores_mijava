package com.example.mijava;

import java.io.IOException;


import com.example.mijava.antlr.MijavaLexer;
import com.example.mijava.antlr.MijavaParser;
import com.example.mijava.ast.ASTNode;
import com.example.mijava.ast.Program;
import com.example.mijava.mips.MipsFrame;
import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.visitor.ASTBuilderVisitor;
import com.example.mijava.visitor.IRTree.IRTreeVisitor;
import com.example.mijava.visitor.IRTree.ProcFrag;
import com.example.mijava.canon.*;


import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.CharStreams;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MijavaApplication {

	public static void main(String[] args) throws IOException {
        CharStream input = CharStreams.fromFileName("src/main/resources/entrega1_tests/BinarySearch.java");
        MijavaLexer lexer = new MijavaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MijavaParser parser = new MijavaParser(tokens);

        ParseTree tree = parser.program();
        //System.out.println(tree.toStringTree(parser));


       // AST
       ASTBuilderVisitor ASTvisitor = new ASTBuilderVisitor();
       ASTNode root = ASTvisitor.visit(tree);
      // System.out.println(root.printNode());

       SymTabScopeNode globalScope = new SymTabScopeNode("global", null);

        root.createSymTab(globalScope);
        ASTNode.printSymTabScope();

        root.typeCheck(globalScope);
        for( String erro: ASTNode.semanticErrorMsg){
            System.out.println(erro);    
        }

        SymTabScopeNode mainScope = ASTNode.mainScope;
        var frame = new MipsFrame();
        IRTreeVisitor irTree = new IRTreeVisitor(mainScope, frame);
        root.accept(irTree);


//        var frag = irTree.getInitialFrag().getNext();
//        while (frag != null) {
//        if (frag instanceof ProcFrag procFrag) {
//                System.out.println("\n--- Método: " + procFrag.getFrame().name + " ---");
//                System.out.println(procFrag.getBody()); // Usa o toString() recursivo!
//        }
//        frag = frag.getNext();
//        }
//
//        var nextFrag = (ProcFrag) irTree.getInitialFrag().getNext();
//        var canonIRTree = new TraceSchedule(new BasicBlocks(Canon.linearize(nextFrag.getBody())));
//
//        System.out.println(">> /n Intermediate Cannonical Code <<");
//        for (var i = canonIRTree.stms; i != null; i = i.tail) {
//                System.out.println(i.head);
//        }

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

	// SpringApplication.run(MijavaApplication.class, args);
       
	}

}