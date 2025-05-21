package com.example.mijava.ast;

import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.visitor.ASTVisitor;

public abstract class Expression extends ASTNode{

  protected int line;
  protected int charpos; 
  protected String name;
  
  public Expression(){
     this.name = "#";
  }

  Expression(int line, int charpos){
    this.line = line;
    this.charpos = charpos;
    this.name = "#";

  }

  public String printNode(){
    return "";
  }

  public String getTypeErr( int errorNumber, String msg, String require, String get){
    return "Erro Semântico: Linha " + line + ": " + charpos + " " + msg +
            "\n\tR: " +  require + ", G: " + get;
  }

  public void createSymTab(SymTabScopeNode escopoAtual){}

  public String typeCheck(SymTabScopeNode escopoAtual){           
      return "";
  }

  public abstract <T> T accept(ASTVisitor<T> v); 
}

