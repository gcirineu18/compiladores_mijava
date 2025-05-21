package com.example.mijava.ast;

import java.util.List;

import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.symbol.SymbolEntry;
import com.example.mijava.visitor.ASTVisitor;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FormalList extends ASTNode {
    private Type type;
    private Id identifier;
    private List<FormalRest> formalRest;

    public FormalList(Type type, Id identifier,List<FormalRest> formalRest ) {
        this.type = type;
        this.identifier = identifier;
        this.formalRest = formalRest;
    }

    @Override
    public String printNode() {
        StringBuilder builder = new StringBuilder("FormalList ( ");
        builder.append(type.printNode()).append(" , ");
        builder.append(identifier.printNode()).append(" , ");

        for (FormalRest f : formalRest){
            builder.append(f.printNode()).append(" , ");
        }
        builder.append(" )");
        return builder.toString();
    }


    @Override
    public void createSymTab(SymTabScopeNode curScope) {

        SymbolEntry argentry = new SymbolEntry("arg", type.name);
        if (!curScope.insertSym(identifier.getS(), argentry)) {
            semanticErrorNumber++;
            semanticErrorMsg.add(identifier.Getsemanticerr(semanticErrorNumber, "Duplicate arg definition"));
        }

        for (FormalRest rest : formalRest) {
            rest.createSymTab(curScope);
        }
    }

    @Override
    public String typeCheck(SymTabScopeNode curScope) {

        if (!identifier.typeCheck(curScope).equals(type.name)) {
            semanticErrorNumber++;
            semanticErrorMsg.add(identifier.GetTypeErr(semanticErrorNumber, "Type Error", type.name, curScope.getSymTab(identifier.getS()).getKind()));
        }

        for (FormalRest rest : formalRest) {
            rest.typeCheck(curScope);
        }
        return "null";
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}