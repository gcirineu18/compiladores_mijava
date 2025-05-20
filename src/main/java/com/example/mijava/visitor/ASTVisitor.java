package com.example.mijava.visitor;

import com.example.mijava.ast.*;
import com.example.mijava.classes_provisorio.Call;
import com.example.mijava.classes_provisorio.ClassDeclExtends;
import com.example.mijava.classes_provisorio.ClassDeclSimple;
import com.example.mijava.classes_provisorio.False;
import com.example.mijava.classes_provisorio.IdentifierType;
import com.example.mijava.classes_provisorio.IntArrayType;
import com.example.mijava.classes_provisorio.IntegerType;
import com.example.mijava.classes_provisorio.LessThan;
import com.example.mijava.classes_provisorio.Minus;
import com.example.mijava.classes_provisorio.Plus;
import com.example.mijava.classes_provisorio.Times;
import com.example.mijava.classes_provisorio.True;

public interface ASTVisitor<T> {
    T visit(Program program);
    T visit(MainClass mainClass);
    T visit(ClassDecl classDecl);
    T visit(VarDecl varDecl);
    T visit(Id id);
    T visit(MethodDecl methodDecl);
    T visit(Formal formal);
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
    // T visit(True t);
	// T visit(False f);
    // T visit(Call c);
    // T visit(IdentifierExpression i);
    // T visit(IdentifierType i);
    // T visit(Plus p);
	// T visit(Minus m);
	// T visit(Times t);
    // T visit(IntegerType i);
    // T visit(IntArrayType i);
    // T visit(LessThan l);
    // T visit(ClassDeclSimple c);
    // T visit(ClassDeclExtends c);
}