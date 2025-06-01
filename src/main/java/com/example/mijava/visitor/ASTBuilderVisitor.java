package com.example.mijava.visitor;

import java.util.ArrayList;
import java.util.List;

import com.example.mijava.antlr.MijavaBaseVisitor;
import com.example.mijava.antlr.MijavaParser;
import com.example.mijava.ast.*;


public class ASTBuilderVisitor extends MijavaBaseVisitor<ASTNode>{
    

    @Override
    public ASTNode visitProgram(MijavaParser.ProgramContext ctx){
        MainClass mainClass =  (MainClass) visit(ctx.mainClass());
        List<ClassDecl> classDecls = new ArrayList<>();
        for(int i = 0; i < ctx.classDecl().size(); i++){
            classDecls.add((ClassDecl) visit(ctx.classDecl(i)));
        }
        return new Program(mainClass, classDecls);
    }


    @Override
    public ASTNode visitMainClass(MijavaParser.MainClassContext ctx){
        
        Id className =  new Id(ctx.ID(0).getText(), ctx.ID(0).getSymbol().getLine(), ctx.ID(0).getSymbol().getCharPositionInLine());
        Id argsName =  new Id(ctx.ID(1).getText(), ctx.ID(1).getSymbol().getLine(), ctx.ID(1).getSymbol().getCharPositionInLine());
        Statement statement = (Statement) visit(ctx.statement());

        return new MainClass(className, argsName, statement);
    } 
    
    @Override
    public ASTNode visitClassDecl(MijavaParser.ClassDeclContext ctx){
          
        List<VarDecl> varDecl =  new ArrayList<VarDecl>();
            for(int i = 0; i < ctx.varDecl().size(); i++){
                varDecl.add((VarDecl) visit(ctx.varDecl(i)));
            }

        List<MethodDecl> methodDecl = new ArrayList<MethodDecl>();
            for(int i = 0; i < ctx.methodDecl().size(); i++){
                methodDecl.add((MethodDecl) visit(ctx.methodDecl(i)));
            }


        Id id = new Id(ctx.ID(0).getText(), ctx.ID(0).getSymbol().getLine(), ctx.ID(0).getSymbol().getCharPositionInLine());
         
        if(ctx.ID().size() == 1){
            return new ClassDeclSimple(id, varDecl, methodDecl);
        }
        
        Id superclass =  new Id(ctx.ID(1).getText(), ctx.ID(1).getSymbol().getLine(), ctx.ID(1).getSymbol().getCharPositionInLine());


        return new ClassDeclExtends(id, superclass, varDecl, methodDecl);
    }

    @Override
    public ASTNode visitVarDecl(MijavaParser.VarDeclContext ctx){
        
        Id identifier =  new Id(ctx.ID().getText(), ctx.ID().getSymbol().getLine(), ctx.ID().getSymbol().getCharPositionInLine());
        Type type = (Type) visit(ctx.type());

        return new VarDecl(identifier, type);
    }
    
    @Override
    public ASTNode visitMethodDecl(MijavaParser.MethodDeclContext ctx){
        Type type = (Type) visit(ctx.type());
        Id methodName =  new Id(ctx.ID().getText(), ctx.ID().getSymbol().getLine(), ctx.ID().getSymbol().getCharPositionInLine());


        List<FormalList> formalList =  new ArrayList<FormalList>();
            for(int i = 0; i < ctx.formalList().size(); i++){
                formalList.add((FormalList) visit(ctx.formalList(i)));
            }


        List<VarDecl> varDecl =  new ArrayList<VarDecl>();
            for(int i = 0; i < ctx.varDecl().size(); i++){
                varDecl.add((VarDecl) visit(ctx.varDecl(i)));
            }

        List<Statement> statement =  new ArrayList<Statement>();
            for(int i = 0; i < ctx.statement().size(); i++){
                statement.add((Statement) visit(ctx.statement(i)));
            } 
            
        Expression expr = (Expression) visit(ctx.expression());  


        return new MethodDecl(type, methodName, formalList, varDecl, statement, expr);
    }
    
    @Override
    public ASTNode visitFormalList(MijavaParser.FormalListContext ctx){
         
        Id identifier =  new Id(ctx.ID().getText(), ctx.ID().getSymbol().getLine(), ctx.ID().getSymbol().getCharPositionInLine());
        Type type = (Type) visit(ctx.type());

        return new FormalList(type, identifier);
    }




    @Override
    public ASTNode visitIntArrayType(MijavaParser.IntArrayTypeContext ctx){
        return new IntArrayType();
    }

    @Override
    public ASTNode visitBooleanType(MijavaParser.BooleanTypeContext ctx){
        return new BooleanType();
    }


    @Override
    public ASTNode visitIntegerType(MijavaParser.IntegerTypeContext ctx){
        return new IntegerType();
    }

    @Override
    public ASTNode visitIdentifierType(MijavaParser.IdentifierTypeContext ctx){
        return new IdentifierType(ctx.getText());
    }

    @Override
    public ASTNode visitBlockStatement(MijavaParser.BlockStatementContext ctx){
        List<Statement> statement = new ArrayList<>();
            for(int i = 0; i < ctx.statement().size(); i++){
                statement.add((Statement) visit(ctx.statement(i)));
            }
        return new BlockStatement(statement);
    }

    @Override
    public ASTNode visitIfStatement(MijavaParser.IfStatementContext ctx){
        Expression expression = (Expression) visit(ctx.expression());
        Statement statement1 = (Statement) visit(ctx.statement(0));
        Statement statement2 = (Statement) visit(ctx.statement(1));

        return new IfStatement(expression, statement1, statement2);
    }

    @Override
    public ASTNode visitWhileStatement(MijavaParser.WhileStatementContext ctx){
        Expression expression = (Expression) visit(ctx.expression());
        Statement statement = (Statement) visit(ctx.statement());

        return new WhileStatement(expression, statement);
    }

    @Override
    public ASTNode visitPrintStatement(MijavaParser.PrintStatementContext ctx){
        Expression expression = (Expression) visit(ctx.expression());
        return new PrintStatement(expression);
    }

    @Override
    public ASTNode visitAssignStatement(MijavaParser.AssignStatementContext ctx){
        Id id =  new Id(ctx.ID().getText(), ctx.ID().getSymbol().getLine(), ctx.ID().getSymbol().getCharPositionInLine());
        Expression expression = (Expression) visit(ctx.expression());

        return new AssignStatement(id, expression);
    }

    @Override
    public ASTNode visitArrayAssignStatement(MijavaParser.ArrayAssignStatementContext ctx){
        Id id =  new Id(ctx.ID().getText(), ctx.ID().getSymbol().getLine(), ctx.ID().getSymbol().getCharPositionInLine());
        Expression expression1 = (Expression) visit(ctx.expression(0));
        Expression expression2 = (Expression) visit(ctx.expression(1));

        return new ArrayAssignStatement(id, expression1, expression2);
    }


    @Override
    public ASTNode visitNewObjectExpression(MijavaParser.NewObjectExpressionContext ctx) {
        Id id = new Id(ctx.ID().getText(), ctx.ID().getSymbol().getLine(), ctx.ID().getSymbol().getCharPositionInLine());
        return new NewObjectExpression(id);
    }

    @Override
    public ASTNode visitBinaryExpression(MijavaParser.BinaryExpressionContext ctx) {

          Expression left = (Expression) visit(ctx.expression(0));
         Expression right = (Expression) visit(ctx.expression(1));

    BinaryExpression node;
    String operator = null;

    if (ctx.ADD() != null) {
        node = new Add(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        operator = "+";
    } else if (ctx.SUB() != null) {
        node = new Sub(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        operator = "-";
    } else if (ctx.MUL() != null) {
        node = new Mul(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        operator = "*";
    } else if (ctx.LT() != null) {
        node = new LessThan(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        operator = "<";
    } else if (ctx.AND() != null) {
        node = new AndExpression(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        operator = "&&";
    } else {
        throw new RuntimeException("Operador binário não reconhecido!");
    }


    node.left = left;
    node.right = right;

    return node;
        
    }


    @Override
    public ASTNode visitArrayAccessExpression(MijavaParser.ArrayAccessExpressionContext ctx) {

        Expression array = (Expression) visit(ctx.expression(0));
        Expression index = (Expression) visit(ctx.expression(1));

        return new ArrayAccessExpression(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), array, index);
    }

    @Override
    public ASTNode visitArrayLengthExpression(MijavaParser.ArrayLengthExpressionContext ctx) {
        Expression array  = (Expression) visit(ctx.expression());
        return new ArrayLengthExpression(array);
    }

    @Override
    public ASTNode visitMethodCallExpression(MijavaParser.MethodCallExpressionContext ctx) {
        Id id =  new Id(ctx.ID().getText(), ctx.ID().getSymbol().getLine(), ctx.ID().getSymbol().getCharPositionInLine());
        Expression expr = (Expression) visit(ctx.expression(0));

        List<Expression> expressions = new ArrayList<>();
        for (int i = 1; i < ctx.expression().size(); i++){
            expressions.add((Expression) visit(ctx.expression(i)));
        }

        return new MethodCallExpression(expr, id, expressions);
    }

    @Override
    public ASTNode visitIntergerLiteralExpression(MijavaParser.IntergerLiteralExpressionContext ctx) {
        return new IntegerLiteralExpression(Integer.parseInt(ctx.INTEGER_LITERAL().getText()));
    }

    @Override
    public ASTNode visitTrueExpression(MijavaParser.TrueExpressionContext ctx) {
    return new TrueExpression(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
  }

    @Override
    public ASTNode visitFalseExpression(MijavaParser.FalseExpressionContext ctx) {
        return new FalseExpression(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public ASTNode visitIdentifierExpression(MijavaParser.IdentifierExpressionContext ctx) {
        return new IdentifierExpression(ctx.getText(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public ASTNode visitThisExpression(MijavaParser.ThisExpressionContext ctx) {
        return new ThisExpression(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public ASTNode visitNewArrayExpression(MijavaParser.NewArrayExpressionContext ctx) {
        Expression expression = (Expression) visit(ctx.expression());
        return new NewArrayExpression(expression);
    }

    @Override
    public ASTNode visitNotExpression(MijavaParser.NotExpressionContext ctx) {
        Expression expression = (Expression) visit(ctx.expression());
        return new NotExpression(expression);
    }

    @Override
    public ASTNode visitInnerExpression(MijavaParser.InnerExpressionContext ctx) { 
    return visit(ctx.expression());
    }

    @Override
    public ASTNode visitIdentifier(MijavaParser.IdentifierContext ctx){
         return new Id(ctx.ID().getText(), ctx.ID().getSymbol().getLine(), ctx.ID().getSymbol().getCharPositionInLine());

    }


}

