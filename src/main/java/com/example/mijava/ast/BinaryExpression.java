package com.example.mijava.ast;

import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.visitor.ASTVisitor;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BinaryExpression extends Expression {
    public Expression left;
    public Expression right;
    public String operator;

    public BinaryExpression(int line, int charpos){
        super(line, charpos);
    }

    @Override
    public void createSymTab(SymTabScopeNode escopoAtual) {
    }

    @Override
    public String typeCheck(SymTabScopeNode escopoAtual) {
         if(!left.typeCheck(escopoAtual).equals("IntegerType")){
                semanticErrorNumber++;
                semanticErrorMsg.add(left.getTypeErr(semanticErrorNumber, "Type Error in Binary Expression", "IntegerType", left.typeCheck(escopoAtual)));
            }
            if(!right.typeCheck(escopoAtual).equals("IntegerType")){
                semanticErrorNumber++;
                semanticErrorMsg.add(right.getTypeErr(semanticErrorNumber, "Type Error in Binary Expression", "IntegerType", right.typeCheck(escopoAtual)));
            }
            return "IntegerType";
    }

    @Override
    public String printNode() {
        return "";
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
  
}
