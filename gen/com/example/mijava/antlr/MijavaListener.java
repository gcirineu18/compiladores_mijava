// Generated from /home/guilherme/Documentos/Documentos_Importantes/UFC/7_semestre/Compiladores/mijava/src/main/java/com/example/mijava/antlr/Mijava.g4 by ANTLR 4.13.2
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
	 * Enter a parse tree produced by the {@code intArrayType}
	 * labeled alternative in {@link MijavaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterIntArrayType(MijavaParser.IntArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intArrayType}
	 * labeled alternative in {@link MijavaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitIntArrayType(MijavaParser.IntArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code integerType}
	 * labeled alternative in {@link MijavaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterIntegerType(MijavaParser.IntegerTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code integerType}
	 * labeled alternative in {@link MijavaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitIntegerType(MijavaParser.IntegerTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierType}
	 * labeled alternative in {@link MijavaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierType(MijavaParser.IdentifierTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierType}
	 * labeled alternative in {@link MijavaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierType(MijavaParser.IdentifierTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleanType}
	 * labeled alternative in {@link MijavaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterBooleanType(MijavaParser.BooleanTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleanType}
	 * labeled alternative in {@link MijavaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitBooleanType(MijavaParser.BooleanTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blockStatement}
	 * labeled alternative in {@link MijavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(MijavaParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blockStatement}
	 * labeled alternative in {@link MijavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(MijavaParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifStatement}
	 * labeled alternative in {@link MijavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(MijavaParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStatement}
	 * labeled alternative in {@link MijavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(MijavaParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileStatement}
	 * labeled alternative in {@link MijavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(MijavaParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileStatement}
	 * labeled alternative in {@link MijavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(MijavaParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printStatement}
	 * labeled alternative in {@link MijavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(MijavaParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printStatement}
	 * labeled alternative in {@link MijavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(MijavaParser.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignStatement}
	 * labeled alternative in {@link MijavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterAssignStatement(MijavaParser.AssignStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignStatement}
	 * labeled alternative in {@link MijavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitAssignStatement(MijavaParser.AssignStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayAssignStatement}
	 * labeled alternative in {@link MijavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterArrayAssignStatement(MijavaParser.ArrayAssignStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayAssignStatement}
	 * labeled alternative in {@link MijavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitArrayAssignStatement(MijavaParser.ArrayAssignStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link MijavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierExpression(MijavaParser.IdentifierExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link MijavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierExpression(MijavaParser.IdentifierExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code methodCallExpression}
	 * labeled alternative in {@link MijavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMethodCallExpression(MijavaParser.MethodCallExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code methodCallExpression}
	 * labeled alternative in {@link MijavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMethodCallExpression(MijavaParser.MethodCallExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code falseExpression}
	 * labeled alternative in {@link MijavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFalseExpression(MijavaParser.FalseExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code falseExpression}
	 * labeled alternative in {@link MijavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFalseExpression(MijavaParser.FalseExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link MijavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpression(MijavaParser.NotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link MijavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpression(MijavaParser.NotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intergerLiteralExpression}
	 * labeled alternative in {@link MijavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIntergerLiteralExpression(MijavaParser.IntergerLiteralExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intergerLiteralExpression}
	 * labeled alternative in {@link MijavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIntergerLiteralExpression(MijavaParser.IntergerLiteralExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryExpression}
	 * labeled alternative in {@link MijavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpression(MijavaParser.BinaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryExpression}
	 * labeled alternative in {@link MijavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpression(MijavaParser.BinaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayAccessExpression}
	 * labeled alternative in {@link MijavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccessExpression(MijavaParser.ArrayAccessExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayAccessExpression}
	 * labeled alternative in {@link MijavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccessExpression(MijavaParser.ArrayAccessExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newObjectExpression}
	 * labeled alternative in {@link MijavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNewObjectExpression(MijavaParser.NewObjectExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newObjectExpression}
	 * labeled alternative in {@link MijavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNewObjectExpression(MijavaParser.NewObjectExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code trueExpression}
	 * labeled alternative in {@link MijavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTrueExpression(MijavaParser.TrueExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code trueExpression}
	 * labeled alternative in {@link MijavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTrueExpression(MijavaParser.TrueExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code thisExpression}
	 * labeled alternative in {@link MijavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterThisExpression(MijavaParser.ThisExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code thisExpression}
	 * labeled alternative in {@link MijavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitThisExpression(MijavaParser.ThisExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayLengthExpression}
	 * labeled alternative in {@link MijavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArrayLengthExpression(MijavaParser.ArrayLengthExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayLengthExpression}
	 * labeled alternative in {@link MijavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArrayLengthExpression(MijavaParser.ArrayLengthExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newArrayExpression}
	 * labeled alternative in {@link MijavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNewArrayExpression(MijavaParser.NewArrayExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newArrayExpression}
	 * labeled alternative in {@link MijavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNewArrayExpression(MijavaParser.NewArrayExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code innerExpression}
	 * labeled alternative in {@link MijavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterInnerExpression(MijavaParser.InnerExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code innerExpression}
	 * labeled alternative in {@link MijavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitInnerExpression(MijavaParser.InnerExpressionContext ctx);
}