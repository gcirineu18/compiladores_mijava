package com.example.mijava.ast;

import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.visitor.ASTVisitor;

public abstract class Expression extends ASTNode{

  protected int line;
  protected int column; 
  protected String name;
  
  public Expression(){
     this.name = "#";
  }

  Expression(int line, int column){
    this.line = line;
    this.column = column;
    this.name = "#";

  }

  public String printNode(){
    return "";
  }

  public String getTypeErr( int errorNumber, String msg, String require, String get){
    return "Erro Semântico: Linha " + line + ": " + column + " " + msg +
            "\n\tR: " +  require + ", G: " + get;
  }

  public void createSymTab(SymTabScopeNode escopoAtual){}

  public String typeCheck(SymTabScopeNode escopoAtual){           
      return "";
  }

  public abstract <T> T accept(ASTVisitor<T> v); 
}

