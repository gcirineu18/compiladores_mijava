package com.example.mijava.ast;

import java.util.List;
import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.symbol.SymbolEntry;
import com.example.mijava.visitor.ASTVisitor;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MethodDecl extends ASTNode {
    private Type returnType;
    private Id methodName;
    private List<FormalList> parameters;
    private List<VarDecl> varDecls;
    private List<Statement> statements;
    private Expression returnExpression;
    SymTabScopeNode mscope;

    public MethodDecl(Type returnType, Id methodName, List<FormalList> parameters,
                      List<VarDecl> varDecls, List<Statement> statements,
                      Expression returnExpression) {
        this.returnType = returnType;
        this.methodName = methodName;
        this.parameters = parameters;
        this.varDecls = varDecls;
        this.statements = statements;
        this.returnExpression = returnExpression;
    }

    @Override
    public String printNode() {
        StringBuilder builder = new StringBuilder("MethodDecl ( ");
        builder.append(returnType.printNode()).append(" , ");
        builder.append(methodName.printNode()).append(" , ");
        
        for(FormalList f : parameters){
                builder.append(f.printNode()).append(" , ");
        }
        for(VarDecl v : varDecls){
            builder.append(v.printNode()).append(" , ");
        }
        for(Statement s : statements){
            builder.append(s.printNode()).append(" , ");
        }

        builder.append(returnExpression.printNode()).append(" ) ");
        return builder.toString();
    }


    @Override
    public void createSymTab(SymTabScopeNode curScope) {
        SymbolEntry mentry = new SymbolEntry(returnType.name, "func");
        if (!curScope.insertSym(methodName.getS(), mentry)) {
            semanticErrorNumber++;
            semanticErrorMsg.add(methodName.getsemanticerr(semanticErrorNumber, "Duplicate method definition"));
        }

        mscope = new SymTabScopeNode(methodName.getS(), curScope);
        curScope.next.put(methodName.getS(), mscope);

        int num = 0;
        for(FormalList f : parameters){
            SymbolEntry argentry = new SymbolEntry("arg", f.getType().name, num);
            if (!mscope.insertSym(f.getIdentifier().getS(), argentry)) {
                semanticErrorNumber++;
                semanticErrorMsg.add(f.getIdentifier().getsemanticerr(semanticErrorNumber, "Duplicate arg definition"));
            }
            num ++;
        } 

        for(VarDecl v : varDecls){
            v.createSymTab(mscope);
        }
        for(Statement s : statements){
            s.createSymTab(mscope);
        }

        returnExpression.createSymTab(mscope);

    }

    @Override
    public String typeCheck(SymTabScopeNode curScope) {
        if(!returnExpression.typeCheck(mscope).equals(returnType.name)){
            semanticErrorNumber++;
            semanticErrorMsg.add(methodName.getTypeErr(semanticErrorNumber, "Return value error:", returnType.name, returnExpression.typeCheck(mscope)));
        }
        for(FormalList f : parameters){
            f.typeCheck(mscope);
        }
        for(VarDecl v : varDecls){
            v.typeCheck(mscope);
        }
        for(Statement s : statements){
            s.typeCheck(mscope);
        }
        return "null";
    }


    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}