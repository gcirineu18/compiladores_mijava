package com.example.mijava.ast;
import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.symbol.SymbolEntry;
import com.example.mijava.visitor.ASTVisitor;

import java.util.HashMap;
import java.util.List;

public class MethodCallExpression extends Expression {
    public Expression object;
    public Id methodName;
    public List<Expression> arguments;

    public MethodCallExpression(Expression object, Id methodName, List<Expression> arguments) {
        this.object = object;
        this.methodName = methodName;
        this.arguments = arguments;
    }

    @Override
    public void createSymTab(SymTabScopeNode escopoAtual) {
    }

    @Override
    public String typeCheck(SymTabScopeNode escopoAtual) {
        
        SymTabScopeNode clsSymbolTab;
            if(object.printNode().equals("This")){
                SymTabScopeNode tmpScope = escopoAtual;
                while(tmpScope!=null && !mainScope.next.containsKey(tmpScope.getScopename())){
                    tmpScope = tmpScope.parent;
                }
                if(tmpScope == null){
                    semanticErrorNumber++;
                    semanticErrorMsg.add(object.getTypeErr(semanticErrorNumber, "Type Error in Call Object", "this", "Not exist class scope"));
                    return "null";
                }
                clsSymbolTab = mainScope.next.get(tmpScope.getScopename());
            }
            else{
                String clsname = object.typeCheck(escopoAtual);
                if(!mainScope.next.containsKey(clsname)){
                    semanticErrorNumber++;
                    semanticErrorMsg.add(object.getTypeErr(semanticErrorNumber, "Type Error in Call Object", clsname, "Not exist class name"));
                    return "null";
                }
                if (!methodName.typeCheck(mainScope.next.get(clsname)).equals("func")) {
                    semanticErrorNumber++;
                    semanticErrorMsg.add(object.getTypeErr(semanticErrorNumber, "Type Error in Call Object", "func", 
                    methodName.typeCheck(mainScope.next.get(clsname))));
                    return "null";
                }

                clsSymbolTab = mainScope.next.get(clsname);
            }
            

            String retType = clsSymbolTab.getSymTab(methodName.getS()).getKind();
            HashMap<String, SymbolEntry> fSymTab = clsSymbolTab.next.get(methodName.getS()).getSymTab();

            String [] fpara = new String[fSymTab.size()];
            int fnum = 0;
            for(SymbolEntry values : fSymTab.values()){
                if(values.getKind().equals("arg")){
                    fpara[values.getPos()] = values.getType();
                    fnum ++;
                }
            }
            int num = 0;
     
            if(arguments.size() != fnum){
                    semanticErrorNumber++;
                    semanticErrorMsg.add( "Args Number Error in Call Object " +  Integer.toString(fnum) + ", got "  + Integer.toString(arguments.size()));
                    
                }
            for(Expression enode : arguments){
                // args should match
                
                if(arguments.size() != fnum){
                    semanticErrorNumber++;
                    semanticErrorMsg.add(enode.getTypeErr(semanticErrorNumber, "Args Number Error in Call Object", Integer.toString(fnum), Integer.toString(arguments.size())));
                    break;
                }
                else if(!enode.typeCheck(escopoAtual).equals(fpara[num])){
                    semanticErrorNumber++;
                    semanticErrorMsg.add(enode.getTypeErr(semanticErrorNumber, "Args Type Error in Call Object", fpara[num],enode.typeCheck(escopoAtual)));
                }
                num ++;
            }

            return retType;
    }
    

    @Override
    public String printNode() {
        String ret =  "Call ( " + object.printNode() + " , " + methodName.printNode();
        StringBuilder builder = new StringBuilder(ret);
        for(Expression enode : arguments){
            builder.append(" , ");
            builder.append(enode.printNode());
        }
        builder.append(" ) ");
        return builder.toString();
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}