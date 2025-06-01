package com.example.mijava.ast;

import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.symbol.SymbolEntry;
import com.example.mijava.visitor.ASTVisitor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Id extends Expression{

  private String s;
  private int line;
  private int column;
  
  public Id(String str, int line, int column){
    this.s  = str;
    this.line = line;
    this.column = column;
  }
    public String getsemanticerr(int errornum, String msg){
        return "Erro Semântico, Linha: " + line + ": "+ column +" "+ msg + ":" + s;
    }

    public String getTypeErr(int errornum, String msg, String require, String get){
        return "Erro Semântico, Linha: "+ line + ": " + column +" " + msg + ":" + s +
                "\n\tRequire: " + require + ", Get: "+ get + "\n";
    }

    @Override
    public String printNode() {
        return "Identifier:"+s;
    }

    @Override
    public void createSymTab(SymTabScopeNode curScope) {}

    @Override
    public String typeCheck(SymTabScopeNode curScope){
        SymbolEntry entry;
        
        while(curScope != null){   
               
            if((entry = curScope.getSymTab(s)) != null){

                if( entry.getType().equals("IdentifierType") && !entry.getKind().equals("arg"))
                
                    return entry.getKind();
                else
                    return entry.getType();
            }
            else{
                curScope = curScope.parent;
            }
        }
        semanticErrorNumber ++;
        semanticErrorMsg.add(getsemanticerr(semanticErrorNumber, "Undefined Identifier"));
        return "null";
    }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) {
  return visitor.visit(this);
}

 @Override
 public String toString(){
  return this.s;
 } 
}
