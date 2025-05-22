package com.example.mijava.ast;

import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.visitor.ASTVisitor;

public class ArrayAccessExpression extends BinaryExpression {

        public ArrayAccessExpression(int line, int charpos, Expression array, Expression index){
            super(line, charpos);
            this.left = array;
            this.right = index;
        }
        @Override
        public String printNode() {
            return "ArrayLookup ( " + left.printNode() + " , " + right.printNode() + " ) ";
        }
        @Override
        public String typeCheck(SymTabScopeNode curScope) {
            if(!left.typeCheck(curScope).equals("IntArrayType")){
                semanticErrorNumber++;
                semanticErrorMsg.add(left.getTypeErr(semanticErrorNumber, "Type Error in ArrayLookup Expression", "IntArrayType", left.typeCheck(curScope)));
            }
            if(!right.typeCheck(curScope).equals("IntegerType")){
                semanticErrorNumber++;
                semanticErrorMsg.add(right.getTypeErr(semanticErrorNumber, "Type Error in ArrayLookup Expression", "IntegerType", right.typeCheck(curScope)));
            }
            return "IntegerType";
        }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}