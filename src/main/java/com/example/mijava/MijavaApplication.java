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
        CharStream input = CharStreams.fromFileName("src/main/resources/entrega1_tests/LinkedList.java");
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

        // IR Tree
        SymTabScopeNode mainScope = ASTNode.mainScope;
        var frame = new MipsFrame();
        IRTreeVisitor irTree = new IRTreeVisitor(mainScope, frame);
        root.accept(irTree);

        
        var frag = irTree.getInitialFrag().getNext();
        while (frag != null) {
        if (frag instanceof ProcFrag procFrag) {
                System.out.println("\n--- Método: " + procFrag.getFrame().name + " ---");
                System.out.println(procFrag.getBody()); 
        }
        frag = frag.getNext();
        }

	//SpringApplication.run(MijavaApplication.class, args);
       
	}

}