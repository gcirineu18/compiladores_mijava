package com.example.mijava.mijava;

import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.util.List;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;

import com.example.mijava.antlr.MijavaLexer;
import com.example.mijava.antlr.MijavaParser;
import com.example.mijava.asem.Instr;
import com.example.mijava.asem.InstrList;
import com.example.mijava.ast.ASTNode;
import com.example.mijava.canon.BasicBlocks;
import com.example.mijava.canon.Canon;
import com.example.mijava.canon.TraceSchedule;
import com.example.mijava.irtree.Print;
import com.example.mijava.irtree.StmList;
import com.example.mijava.mips.Codegen;
import com.example.mijava.mips.MipsFrame;
import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.temp.CombineMap;
import com.example.mijava.temp.DefaultMap;
import com.example.mijava.utils.Convert;
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

      //instructionSelection(traceSchedule);

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

    private  void printCanonicalTree(IRTreeVisitor irTree){
        // Para percorrer todos os fragmentos e aplicar a canonização em cada um
        var currentFrag = irTree.getInitialFrag().getNext();
        System.out.println("\n>> Intermediate Canonical Code <<");

        while (currentFrag != null) {
            if (currentFrag instanceof ProcFrag procFrag) {
                System.out.println("\n--- Método: " + procFrag.getFrame().name + " ---");

                Print h = new Print(System.out, new CombineMap(procFrag.getFrame(), new DefaultMap()));

                var canonIRTree = new TraceSchedule(new BasicBlocks(Canon.linearize(procFrag.getBody())));

                for (var i = canonIRTree.stms; i != null; i = i.tail) {
                    System.out.println(i.head);
                }
              
              instructionSelection(procFrag, h);
            }
            currentFrag = currentFrag.getNext();
        }
    }

     private void instructionSelection( ProcFrag procFrag, Print h){
        StmList statements = Canon.linearize(procFrag.getBody());  
        BasicBlocks b = new BasicBlocks(statements);
        StmList t = (new TraceSchedule(b)).stms; 
        List<Instr> instrucoes = procFrag.getFrame().codegen(Convert.StmListToArray(t));

                System.out.println("\u005cnInstrucoes:\u005cn");
        for (int j = 0; j < instrucoes.size(); ++j) {
            System.out.println(instrucoes.get(j).format(h.tmap));
        }

    }

    
}
