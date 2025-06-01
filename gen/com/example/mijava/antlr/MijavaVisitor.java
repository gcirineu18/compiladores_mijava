// Generated from /home/guilherme/Documentos/Documentos_Importantes/UFC/7_semestre/Compiladores/mijava/src/main/java/com/example/mijava/antlr/Mijava.g4 by ANTLR 4.13.2
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
	 * Visit a parse tree produced by the {@code intArrayType}
	 * labeled alternative in {@link MijavaParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntArrayType(MijavaParser.IntArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code integerType}
	 * labeled alternative in {@link MijavaParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerType(MijavaParser.IntegerTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identifierType}
	 * labeled alternative in {@link MijavaParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierType(MijavaParser.IdentifierTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanType}
	 * labeled alternative in {@link MijavaParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanType(MijavaParser.BooleanTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blockStatement}
	 * labeled alternative in {@link MijavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(MijavaParser.BlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifStatement}
	 * labeled alternative in {@link MijavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(MijavaParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileStatement}
	 * labeled alternative in {@link MijavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(MijavaParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printStatement}
	 * labeled alternative in {@link MijavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatement(MijavaParser.PrintStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignStatement}
	 * labeled alternative in {@link MijavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStatement(MijavaParser.AssignStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayAssignStatement}
	 * labeled alternative in {@link MijavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAssignStatement(MijavaParser.ArrayAssignStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link MijavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierExpression(MijavaParser.IdentifierExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code methodCallExpression}
	 * labeled alternative in {@link MijavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCallExpression(MijavaParser.MethodCallExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code falseExpression}
	 * labeled alternative in {@link MijavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseExpression(MijavaParser.FalseExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link MijavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpression(MijavaParser.NotExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intergerLiteralExpression}
	 * labeled alternative in {@link MijavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntergerLiteralExpression(MijavaParser.IntergerLiteralExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryExpression}
	 * labeled alternative in {@link MijavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryExpression(MijavaParser.BinaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayAccessExpression}
	 * labeled alternative in {@link MijavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccessExpression(MijavaParser.ArrayAccessExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newObjectExpression}
	 * labeled alternative in {@link MijavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewObjectExpression(MijavaParser.NewObjectExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code trueExpression}
	 * labeled alternative in {@link MijavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueExpression(MijavaParser.TrueExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code thisExpression}
	 * labeled alternative in {@link MijavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThisExpression(MijavaParser.ThisExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayLengthExpression}
	 * labeled alternative in {@link MijavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLengthExpression(MijavaParser.ArrayLengthExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newArrayExpression}
	 * labeled alternative in {@link MijavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewArrayExpression(MijavaParser.NewArrayExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code innerExpression}
	 * labeled alternative in {@link MijavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInnerExpression(MijavaParser.InnerExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MijavaParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(MijavaParser.IdentifierContext ctx);
}