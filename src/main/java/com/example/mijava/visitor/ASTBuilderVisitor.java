package com.example.mijava.visitor;

import java.util.ArrayList;
import java.util.List;

import com.example.mijava.antlr.MijavaBaseVisitor;
import com.example.mijava.antlr.MijavaParser;
import com.example.mijava.ast.*;


public class ASTBuilderVisitor extends MijavaBaseVisitor<ASTNode>{
    
    @Override
    public ASTNode visitMainClass(MijavaParser.MainClassContext ctx){
        
        Id className = (Id) visit(ctx.ID(0));
        Id argsName = (Id) visit(ctx.ID(1));
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

        Id id = (Id) visit(ctx.ID(0));
        if(ctx.ID().size() == 1){
            return new ClassDeclSimple(id, varDecl, methodDecl);
        }
        
        Id superclass = (Id) visit(ctx.ID(1));

        return new ClassDeclExtends(id, superclass, varDecl, methodDecl);
    }

    @Override
    public ASTNode visitVarDecl(MijavaParser.VarDeclContext ctx){
        
        Id identifier = (Id) visit(ctx.ID());
        Type type = (Type) visit(ctx.type());

        return new VarDecl(identifier, type);
    }
    
    @Override
    public ASTNode visitMethodDecl(MijavaParser.MethodDeclContext ctx){
        Type type = (Type) visit(ctx.type());
        Id methodName = (Id) visit(ctx.ID());
        FormalList formalList = (FormalList) visit(ctx.formalList());

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
        
        Id identifier = (Id) visit(ctx.ID());
        Type type = (Type) visit(ctx.type());

        List<FormalRest> formalRest = new ArrayList<FormalRest>();
        for(int i = 0; i < ctx.formalRest().size(); i++){
                formalRest.add((FormalRest) visit(ctx.formalRest(i)));
            }

        return new FormalList(type, identifier, formalRest);
    }

    @Override
    public ASTNode visitFormalRest(MijavaParser.FormalRestContext ctx){
        
        Id identifier = (Id) visit(ctx.ID());
        Type type = (Type) visit(ctx.type());

        return new FormalRest(type, identifier);
    }


    @Override
    public ASTNode visitIntArrayType(MijavaParser.IntArrayTypeContext ctx){
        return new IntArrayType();
    }

    @Override
    public ASTNode visitBooleanType(MijavaParser.BooleanTypeContext ctx){
        return new IntArrayType();
    }


    @Override
    public ASTNode visitIntegerType(MijavaParser.IntegerTypeContext ctx){
        return new IntegerType();
    }

    @Override
    public ASTNode visitIdentifierType(MijavaParser.IdentifierTypeContext ctx){
        Id id = (Id) visit(ctx.ID());
        return new IdentifierType(id);
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
        Id id = (Id) visit(ctx.ID());
        Expression expression = (Expression) visit(ctx.expression());

        return new AssignStatement(id, expression);
    }

    @Override
    public ASTNode visitArrayAssignStatement(MijavaParser.ArrayAssignStatementContext ctx){
        Id id = (Id) visit(ctx.ID());
        Expression expression1 = (Expression) visit(ctx.expression(0));
        Expression expression2 = (Expression) visit(ctx.expression(1));

        return new ArrayAssignStatement(id, expression1, expression2);
    }


    @Override
    public ASTNode visitNewObjectExpression(MijavaParser.NewObjectExpressionContext ctx) {
        Id id = (Id) visit(ctx.ID());
        return new NewObjectExpression(id);
    }

    @Override
    public ASTNode visitBinaryExpression(MijavaParser.BinaryExpressionContext ctx) {
        Expression left = (Expression) visit(ctx.expression(0));
        Expression right = (Expression) visit(ctx.expression(1));
        String operator;

        if(ctx.ADD() != null){
            operator = "+";
        }
        else if(ctx.SUB() != null){
            operator = "-";
        }
        else if(ctx.MUL() != null){
            operator = "*";
        }
        else if(ctx.LT() != null){
            operator = "<";
        }
        else if(ctx.GT() != null){
            operator = ">";
        }
        else{
            throw new RuntimeException();
        }

        return new BinaryExpression(left, operator, right);
    }


    @Override
    public ASTNode visitArrayAccessExpression(MijavaParser.ArrayAccessExpressionContext ctx) {

        Expression array = (Expression) visit(ctx.expression(0));
        Expression index = (Expression) visit(ctx.expression(0));

        return new ArrayAccessExpression(array, index);
    }

    @Override
    public ASTNode visitArrayLengthExpression(MijavaParser.ArrayLengthExpressionContext ctx) {
        Expression array  = (Expression) visit(ctx.expression());
        return new ArrayLengthExpression(array);
    }

    @Override
    public ASTNode visitMethodCallExpression(MijavaParser.MethodCallExpressionContext ctx) {
        Id id = (Id) visit(ctx.ID());
        Expression expr = (Expression) visit(ctx.expression(0));

        List<Expression> expressions = new ArrayList<>();
        for (int i = 0; i < ctx.expression().size(); i++){
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
        return new TrueExpression();
    }

    @Override
    public ASTNode visitFalseExpression(MijavaParser.FalseExpressionContext ctx) {
        return new FalseExpression();
    }

    @Override
    public ASTNode visitIdentifierExpression(MijavaParser.IdentifierExpressionContext ctx) {
        Id id = (Id) visit(ctx.ID());
        return new IdentifierExpression(id);
    }

    @Override
    public ASTNode visitThisExpression(MijavaParser.ThisExpressionContext ctx) {
        return new ThisExpression();
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

}

