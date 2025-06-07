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


import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.CharStreams;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MijavaApplication {

	public static void main(String[] args) throws IOException {
        CharStream input = CharStreams.fromFileName("src/main/resources/entrega1_tests/Factorial.java");
//      CharStream input = CharStreams.fromString("class Test{ public static void main( String[] args){if (true) System.out.println(1); else System.out.println(0);}}");
        MijavaLexer lexer = new MijavaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MijavaParser parser = new MijavaParser(tokens);

        ParseTree tree = parser.program();
        //System.out.println(tree.toStringTree(parser));

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

        // Imprimir a IRTree do método main (statement principal)
        // Supondo que o fragmento inicial do visitor contém o corpo do método main
        // var frag = irTree.getInitialFrag().getNext(); // Pula o frag inicial vazio
        // if (frag instanceof ProcFrag procFrag) {
        //     var stm = procFrag.getBody();
        //     var printer = new com.example.mijava.irtree.Print(System.out);
        //     printer.prStm(stm);
        // }

        // Imprimir todos os métodos (ProcFrag) gerados na IRTree
        // var frag = irTree.getInitialFrag().getNext(); // Pula o frag inicial vazio
        // var printer = new com.example.mijava.irtree.Print(System.out);
        // while (frag != null) {
        //     if (frag instanceof ProcFrag procFrag) {
        //         System.out.println("\n--- Método: " + procFrag.getFrame().name + " ---");
        //         printer.prStm(procFrag.getBody());
        //     }
        //     frag = frag.getNext();
        // }

        // Para imprimir todos os métodos (ProcFrag) gerados na IRTree:
        var frag = irTree.getInitialFrag().getNext(); // Pula o frag inicial vazio
        while (frag != null) {
        if (frag instanceof ProcFrag procFrag) {
                System.out.println("\n--- Método: " + procFrag.getFrame().name + " ---");
                System.out.println(procFrag.getBody()); // Usa o toString() recursivo!
        }
        frag = frag.getNext();
        }

	// SpringApplication.run(MijavaApplication.class, args);
       
	}

}