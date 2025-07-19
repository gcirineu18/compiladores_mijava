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
import com.example.mijava.mijava.MijavaCompile;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.CharStreams;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MijavaApplication {

	public static void main(String[] args) throws IOException {

          var mijavaCompiler =  new MijavaCompile();
          
          mijavaCompiler.compile("src/main/resources/entrega1_tests/Factorial.java");
       
	}

}