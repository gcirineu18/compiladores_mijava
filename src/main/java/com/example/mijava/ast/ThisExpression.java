package com.example.mijava.ast;

import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.visitor.ASTVisitor;

public class ThisExpression extends Expression{
   ThisExpression(int line, int column){
      super(line, column);
  }

   @Override
   public String printNode() {
      return "This Expression";
   }
   @Override
   public void createSymTab(SymTabScopeNode escopoAtual) {}

   @Override
   public String typeCheck(SymTabScopeNode escopoAtual) {
      SymTabScopeNode tmpScope = escopoAtual;
      while(tmpScope!=null && !mainScope.next.containsKey(tmpScope.getScopename())){
            tmpScope = tmpScope.parent;
      }
      if(tmpScope == null){
            semanticErrorNumber++;
            semanticErrorMsg.add(this.getTypeErr(semanticErrorNumber, "Type Error in This Object", "this", "Not exist class scope"));
            return "null";
      }
      return tmpScope.getScopename();
   }

   @Override
   public <T> T accept(ASTVisitor<T> visitor) {
      return visitor.visit(this);
   }
}