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

        MainClass node = new MainClass(className, argsName, statement);

         return node; 
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
            ClassDeclSimple node = new ClassDeclSimple(id, varDecl, methodDecl);         
            return node;
        }
        
        Id superclass = (Id) visit(ctx.ID(1));
        ClassDeclExtends node = new ClassDeclExtends(id, superclass, varDecl, methodDecl);         
        
        return node;
    }

    @Override
    public ASTNode visitVarDecl(MijavaParser.VarDeclContext ctx){
        
        Id identifier = (Id) visit(ctx.ID());
        Type type = (Type) visit(ctx.type());
              
        VarDecl node = new VarDecl(identifier, type);

         return node; 
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
        MethodDecl node = new MethodDecl(type, methodName, formalList, varDecl, statement, expr);

        return node;
    }
    
    @Override
    public ASTNode visitFormalList(MijavaParser.FormalListContext ctx){
        
        Id identifier = (Id) visit(ctx.ID());
        Type type = (Type) visit(ctx.type());

        List<FormalRest> formalRest = new ArrayList<FormalRest>();
        for(int i = 0; i < ctx.formalRest().size(); i++){
                formalRest.add((FormalRest) visit(ctx.formalRest(i)));
            }   

        FormalList  node = new FormalList(type, identifier, formalRest);

        return node; 
    }

    @Override
    public ASTNode visitFormalRest(MijavaParser.FormalRestContext ctx){
        
        Id identifier = (Id) visit(ctx.ID());
        Type type = (Type) visit(ctx.type());

        FormalRest  node = new FormalRest(type, identifier);

        return node; 
    }


    


}    
