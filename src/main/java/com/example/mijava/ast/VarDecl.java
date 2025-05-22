package com.example.mijava.ast;

import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.symbol.SymbolEntry;
import com.example.mijava.visitor.ASTVisitor;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VarDecl extends ASTNode {
    private Id identifier;
    private Type type;


    public VarDecl(Id id, Type type) {
        this.identifier = id;
        this.type = type;
    }

    @Override
    public String printNode() {
        return "VarDecl ( " + type.printNode() + " , " + identifier.printNode() + " ) ";
    }

    @Override
    public void createSymTab(SymTabScopeNode curScope){
        SymbolEntry varentry;
        varentry = new SymbolEntry("var", type.name);
        if(!curScope.insertSym(identifier.getS(), varentry)){
            semanticErrorNumber ++;
            semanticErrorMsg.add(identifier.getsemanticerr(semanticErrorNumber, "Duplicate var definition"));
        }
    }

    @Override
    public String typeCheck(SymTabScopeNode curScope) {
        if (!identifier.typeCheck(curScope).equals(type.name)) {
            semanticErrorNumber++;
            semanticErrorMsg.add(identifier.getTypeErr(semanticErrorNumber, "Type Error", type.name, identifier.typeCheck(curScope)));
        }
        return "null";
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this); 
    }
}