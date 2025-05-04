// Generated from com/example/mijava/antlr/Mijava.g4 by ANTLR 4.13.2
package com.example.mijava.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MijavaParser}.
 */
public interface MijavaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MijavaParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MijavaParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MijavaParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MijavaParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MijavaParser#mainClass}.
	 * @param ctx the parse tree
	 */
	void enterMainClass(MijavaParser.MainClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link MijavaParser#mainClass}.
	 * @param ctx the parse tree
	 */
	void exitMainClass(MijavaParser.MainClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link MijavaParser#classDecl}.
	 * @param ctx the parse tree
	 */
	void enterClassDecl(MijavaParser.ClassDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MijavaParser#classDecl}.
	 * @param ctx the parse tree
	 */
	void exitClassDecl(MijavaParser.ClassDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MijavaParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(MijavaParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MijavaParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(MijavaParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MijavaParser#methodDecl}.
	 * @param ctx the parse tree
	 */
	void enterMethodDecl(MijavaParser.MethodDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MijavaParser#methodDecl}.
	 * @param ctx the parse tree
	 */
	void exitMethodDecl(MijavaParser.MethodDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MijavaParser#formalList}.
	 * @param ctx the parse tree
	 */
	void enterFormalList(MijavaParser.FormalListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MijavaParser#formalList}.
	 * @param ctx the parse tree
	 */
	void exitFormalList(MijavaParser.FormalListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MijavaParser#formalRest}.
	 * @param ctx the parse tree
	 */
	void enterFormalRest(MijavaParser.FormalRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link MijavaParser#formalRest}.
	 * @param ctx the parse tree
	 */
	void exitFormalRest(MijavaParser.FormalRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link MijavaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(MijavaParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MijavaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(MijavaParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MijavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MijavaParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MijavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MijavaParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MijavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MijavaParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MijavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MijavaParser.ExpressionContext ctx);
}