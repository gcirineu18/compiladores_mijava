package com.example.mijava.ast;

import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.visitor.ASTVisitor;

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
        if (object != null) {
            object.createSymTab(escopoAtual);
        }

        methodName.createSymTab(escopoAtual);

        if (arguments != null) {
            for (Expression arg : arguments) {
                arg.createSymTab(escopoAtual);
            }
        }
    }

    @Override
    public String typeCheck(SymTabScopeNode escopoAtual) {
        SymTabScopeNode classeSymbolTab;

        if (object == null) {
            SymTabScopeNode escopoTemp = escopoAtual;
            while (escopoTemp != null && !escopoTemp.isClassScope()) {
                escopoTemp = escopoTemp.parent;
            }
            if (escopoTemp == null) {
                return "null";
            }
            classeSymbolTab = escopoTemp;
        } else {
            String nomeClasse = object.typeCheck(escopoAtual);

            SymTabScopeNode escopoGlobal = getGlobalScope(escopoAtual);
            if (escopoGlobal == null || !escopoGlobal.containsClass(nomeClasse)) {
                return "null";
            }

            classeSymbolTab = escopoGlobal.getClassScope(nomeClasse);
        }

        String nomeMetodo = methodName.getS();
        if (!classeSymbolTab.containsMethod(nomeMetodo)) {
            return "null";
        }

        String tipoRetorno = classeSymbolTab.getMethodReturnType(nomeMetodo);
        SymTabScopeNode escopoMetodo = classeSymbolTab.getMethodScope(nomeMetodo);

        List<String> tiposParametros = escopoMetodo.getParameterTypes();
        int numParametros = tiposParametros.size();

        if (arguments != null) {
            if (arguments.size() != numParametros) {
            } else {
                for (int i = 0; i < arguments.size(); i++) {
                    String tipoArgumento = arguments.get(i).typeCheck(escopoAtual);
                    if (!tipoArgumento.equals(tiposParametros.get(i))) {
                    }
                }
            }
        } else if (numParametros > 0) {
        }

        return tipoRetorno;
    }

    private SymTabScopeNode getGlobalScope(SymTabScopeNode escopo) {
        SymTabScopeNode atual = escopo;
        while (atual.parent != null) {
            atual = atual.parent;
        }
        return atual;
    }
    private String GetTypeErr(int errornum, String msg, String require, String get) {
        return "Erro Semântico: " + msg +
                "\n\tEsperado: " + require + ", Obtido: " + get;
    }

    @Override
    public String printNode() {
        StringBuilder sb = new StringBuilder();

        if (object != null) {
            sb.append(object.printNode());
            sb.append(".");
        }

        sb.append(methodName.printNode());
        sb.append("(");

        if (arguments != null && !arguments.isEmpty()) {
            for (int i = 0; i < arguments.size(); i++) {
                sb.append(arguments.get(i).printNode());
                if (i < arguments.size() - 1) {
                    sb.append(", ");
                }
            }
        }

        sb.append(")");

        return sb.toString();
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}