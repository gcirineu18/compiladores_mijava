package com.example.mijava.ast;

import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.symbol.SymbolEntry;
import com.example.mijava.visitor.ASTVisitor;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class MainClass extends ASTNode {
    private Id className;
    private Id argsName;
    private Statement statement;
    SymTabScopeNode clsScope;

    public MainClass(Id className, Id argsName, Statement statement) {
        this.className = className;
        this.argsName = argsName;
        this.statement = statement;
    }
    @Override
    public String printNode() {
            return "MainClass ( " + className.printNode() + " , " + argsName.printNode() + " , " + statement.printNode() + " ) ";
        }

    @Override
    public void createSymTab(SymTabScopeNode curScope){
            SymbolEntry clsentry = new SymbolEntry("class", "class");
            if(!curScope.insertSym(className.getS(), clsentry)){
                semanticErrorNumber ++;
                semanticErrorMsg.add(className.getsemanticerr(semanticErrorNumber, "Duplicate class definition"));
            }                          
   
            clsScope = new SymTabScopeNode(className.getS(), curScope);
            curScope.next.put(className.getS(), clsScope);

            SymbolEntry fentry = new SymbolEntry("void", "func");
            clsScope.insertSym("main", fentry);

            SymTabScopeNode fScope = new SymTabScopeNode("main", clsScope);
            clsScope.next.put("main",fScope);
            SymbolEntry argentry = new SymbolEntry("arg", "String[]");
            if(!fScope.insertSym(argsName.getS(), argentry)){
                semanticErrorNumber ++;
                semanticErrorMsg.add(argsName.getsemanticerr(semanticErrorNumber, "Duplicate arg definition"));
            }

            statement.createSymTab(fScope);

        }
    @Override
    public String typeCheck(SymTabScopeNode curScope) {
        statement.typeCheck(curScope.next.get("main"));
        return "null";
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}