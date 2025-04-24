// Generated from com/example/mijava/antlr/Mijava.g4 by ANTLR 4.13.2
package com.example.mijava.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MijavaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MijavaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MijavaParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MijavaParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MijavaParser#mainClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainClass(MijavaParser.MainClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link MijavaParser#classDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDecl(MijavaParser.ClassDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MijavaParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(MijavaParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MijavaParser#methodDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDecl(MijavaParser.MethodDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MijavaParser#formalList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalList(MijavaParser.FormalListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MijavaParser#formalRest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalRest(MijavaParser.FormalRestContext ctx);
	/**
	 * Visit a parse tree produced by {@link MijavaParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(MijavaParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MijavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MijavaParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MijavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(MijavaParser.ExpressionContext ctx);
}