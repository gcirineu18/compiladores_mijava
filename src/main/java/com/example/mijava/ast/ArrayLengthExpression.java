package com.example.mijava.ast;

import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.visitor.ASTVisitor;

public class ArrayLengthExpression extends Expression {
    public Expression array;

    public ArrayLengthExpression(Expression array) {
        this.array = array;
    }

    @Override
    public void createSymTab(SymTabScopeNode escopoAtual) {
    }

    @Override
    public String typeCheck(SymTabScopeNode escopoAtual) {
         String clsname;
            if(array.printNode().equals("This")){
                return "IntegerType";
            }
            else {
                clsname = array.typeCheck(escopoAtual);
                if(!mainScope.next.containsKey(clsname) && !clsname.equals("IntArrayType")){
                    semanticErrorNumber++;
                    semanticErrorMsg.add(array.getTypeErr(semanticErrorNumber, "Type Error in ArrayLength Expression",
                     clsname, "Not exist class name"));
                }
            }

            return "IntegerType";
    }

    @Override
    public String printNode() {
        return array.printNode() + ".length";
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}