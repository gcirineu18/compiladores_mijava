package com.example.mijava.visitor;

import com.example.mijava.ast.*;

public interface ASTVisitor<T> {
    T visit(Program program);
    T visit(MainClass mainClass);
    T visit(ClassDecl classDecl);
    T visit(VarDecl varDecl);
    T visit(Id id);
    T visit(MethodDecl methodDecl);
    T visit(Formal formal);
    T visit(Type type);
    T visit(BlockStatement statement);
    T visit(IfStatement statement);
    T visit(WhileStatement statement);
    T visit(PrintStatement statement);
    T visit(AssignStatement statement);
    T visit(ArrayAssignStatement statement);
    T visit(BinaryExpression expression);
    T visit(ArrayAccessExpression expression);
    T visit(ArrayLengthExpression expression);
    T visit(MethodCallExpression expression);
    T visit(IntegerLiteralExpression expression);
    T visit(BooleanLiteralExpression expression);
    T visit(ThisExpression expression);
    T visit(NewArrayExpression expression);
    T visit(NewObjectExpression expression);
    T visit(NotExpression expression);
}