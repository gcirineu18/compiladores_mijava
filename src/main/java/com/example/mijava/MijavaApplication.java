package com.example.mijava;

import java.io.IOException;


import com.example.mijava.antlr.MijavaLexer;
import com.example.mijava.antlr.MijavaParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.CharStreams;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MijavaApplication {

	public static void main(String[] args) throws IOException {
        
		 CharStream input = CharStreams.fromString("class Test{ public static void main( String[] args){if (true) System.out.println(1); else System.out.println(0);}}");
         MijavaLexer lexer = new MijavaLexer(input);
         CommonTokenStream tokens = new CommonTokenStream(lexer);
         MijavaParser parser = new MijavaParser(tokens);

         ParseTree tree = parser.program();  
         System.out.println(tree.toStringTree(parser));
	   //   SpringApplication.run(MijavaApplication.class, args);
	}

}