package com.example.mijava.ast;

import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.symbol.SymbolEntry;
import com.example.mijava.visitor.ASTVisitor;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FormalList extends ASTNode {
    private Type type;
    private Id identifier;


    public FormalList(Type type, Id identifier ) {
        this.type = type;
        this.identifier = identifier;
    }

    @Override
    public String printNode() {
      return "Formal ( " + type.printNode() + " , " + identifier.printNode() + " )  ";    
    }


    @Override
    public void createSymTab(SymTabScopeNode curScope) {

        SymbolEntry argentry = new SymbolEntry("arg", type.name);
        if (!curScope.insertSym(identifier.getS(), argentry)) {
            semanticErrorNumber++;
            semanticErrorMsg.add(identifier.getsemanticerr(semanticErrorNumber, "Duplicate arg definition"));
        }
    }

    @Override
    public String typeCheck(SymTabScopeNode curScope) {

        if (!identifier.typeCheck(curScope).equals(type.name)) {
            semanticErrorNumber++;
            semanticErrorMsg.add(identifier.getTypeErr(semanticErrorNumber, "Type Error", type.name, curScope.getSymTab(identifier.getS()).getKind()));
        }

        return "null";
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}