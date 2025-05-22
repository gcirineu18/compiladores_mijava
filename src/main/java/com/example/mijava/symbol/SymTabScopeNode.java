package com.example.mijava.symbol;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
@Setter
public class SymTabScopeNode {
    String Scopename;
    private HashMap<String, SymbolEntry> SymTab;
    public HashMap<String, SymTabScopeNode> next;
    public SymTabScopeNode parent;

    public SymTabScopeNode(String name, SymTabScopeNode p){
        this.Scopename = name;
        this.SymTab = new HashMap<>();
        this.parent = p;
        this.next = new HashMap<>();
    }

    public SymbolEntry getSymTab(String name) {
        return SymTab.getOrDefault(name, null);
    }

    public boolean insertSym(String name, SymbolEntry symbol){
        if(SymTab.containsKey(name))
            return false;

        SymTab.put(name, symbol);
        return true;

    }

    public HashMap<String, SymbolEntry> getSymTab(){
        return SymTab;
    }

    public void setSymTab(HashMap<String, SymbolEntry> symtable){
        this.SymTab.putAll(symtable);
    }

    public void printSymTab(){
        for(String key : SymTab.keySet()){
            System.out.println(key + "\t" + "kind:" + SymTab.get(key).getKind() + "\ttype:" + SymTab.get(key).getType() + "\tpos:" + SymTab.get(key).getPos());
        }
    }

    public boolean isClassScope() {
        return parent != null && parent.parent == null && !Scopename.startsWith("Method_");
    }

    public boolean containsClass(String nomeClasse) {
        return next != null && next.containsKey(nomeClasse);
    }

    public SymTabScopeNode getClassScope(String nomeClasse) {
        if (next != null && next.containsKey(nomeClasse)) {
            return next.get(nomeClasse);
        }
        return null;
    }

    

    public boolean containsMethod(String nomeMetodo) {
        return getSymTab().containsKey(nomeMetodo) &&
                getSymTab(nomeMetodo).getKind().equals("func");
    }

    public String getMethodReturnType(String nomeMetodo) {
        if (containsMethod(nomeMetodo)) {
            return getSymTab(nomeMetodo).getType();
        }
        return "null";
    }

    public SymTabScopeNode getMethodScope(String nomeMetodo) {
        if (next != null && next.containsKey(nomeMetodo)) {
            return next.get(nomeMetodo);
        }
        return null;
    }

    public List<String> getParameterTypes() {
        List<String> tiposParametros = new ArrayList<>();
        HashMap<String, SymbolEntry> fSymTab = getSymTab();

        String[] paraTypes = new String[fSymTab.size()];
        int numParams = 0;

        for (SymbolEntry value : fSymTab.values()) {
            if (value.getKind().equals("arg")) {
                paraTypes[value.getPos()] = value.getType();
                numParams++;
            }
        }

        for (int i = 0; i < numParams; i++) {
            tiposParametros.add(paraTypes[i]);
        }

        return tiposParametros;
    }

}
