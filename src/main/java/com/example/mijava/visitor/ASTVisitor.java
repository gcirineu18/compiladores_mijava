package com.example.mijava.visitor;

import com.example.mijava.ast.*;

public interface ASTVisitor<T> {
    T visit(MainClass mainClass);
    T visit(Program program);
    T visit(ClassDecl classDecl);
    T visit(VarDecl varDecl);
    T visit(Id id);
    T visit(MethodDecl methodDecl);
    T visit(FormalList formal);
    T visit(FormalRest formal);
    T visit(Type type);
    T visit(Block statement);
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
    T visit(This expression);
    T visit(NewArray expression);
    T visit(NewObject expression);
    T visit(Not expression);
    T visit(And expression);

    // PENDENTE
    T visit(True expression);
	T visit(False expression);
    // T visit(Call c); --> temos o methodcall
    T visit(IdentifierExpression expression);
    T visit(IdentifierType type);
    T visit(Add expression);
	T visit(Sub expression);
	T visit(Mul expression);
    T visit(IntegerType type);
    T visit(IntArrayType type);
    T visit(LessThan expression);
    T visit(ClassDeclSimple c);
    T visit(ClassDeclExtends c);

}