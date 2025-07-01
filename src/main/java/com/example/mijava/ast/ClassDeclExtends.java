package com.example.mijava.ast;

import java.util.List;

import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.symbol.SymbolEntry;
import com.example.mijava.visitor.ASTVisitor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter 
public class ClassDeclExtends extends ClassDecl {
  public Id id2;
  public List<VarDecl> varDeclList;
  public List<MethodDecl> methodDeclList;
  SymTabScopeNode clsScope;

  public ClassDeclExtends(Id a_id1, Id a_id2,
                          List<VarDecl> a_vdl, List<MethodDecl> a_mdl){
    this.id = a_id1;
    this.id2 = a_id2;
    this.varDeclList = a_vdl;
    this.methodDeclList = a_mdl;
  }

  @Override
  public String printNode() {
    StringBuilder builder = new StringBuilder("ClassDeclExtends ( ");
    builder.append(id.printNode()).append(" , ");
    builder.append(id2.printNode()).append(" , ");
    for(VarDecl v : varDeclList){
      builder.append(v.printNode()).append(" , ");
    }
    for(MethodDecl m : methodDeclList){
      builder.append(m.printNode()).append(" , ");
    }
    builder.delete(builder.length()-3, builder.length());
    builder.append(" ) ");

    return builder.toString();
  }

  @Override
  public void createSymTab(SymTabScopeNode curScope){
    SymbolEntry clsentry = new SymbolEntry("class", "class");
    if(!curScope.insertSym(id.getS(), clsentry)){
      semanticErrorNumber ++;
      semanticErrorMsg.add(id.getsemanticerr(semanticErrorNumber, "Duplicate class definition"));
    }

    clsScope = new SymTabScopeNode(id.getS(), curScope);
    curScope.next.put(id.getS(), clsScope);

    for(VarDecl v : varDeclList){
      v.createSymTab(clsScope);
    }
    for(MethodDecl m : methodDeclList){
      m.createSymTab(clsScope);
    }

    // extends
    if(mainScope.next.containsKey(id2.getS())){    
      clsScope.setSymTab(mainScope.next.get(id2.getS()).getSymTab());
    }
    else{
      semanticErrorNumber ++;
      semanticErrorMsg.add(id2.getsemanticerr(semanticErrorNumber, "class identifier does not exist"));
    }

  }


  @Override
  public String typeCheck(SymTabScopeNode curScope) {
    for(VarDecl v : varDeclList){
      v.typeCheck(clsScope);
    }
    for(MethodDecl m : methodDeclList){
      m.typeCheck(clsScope);
    }
    return "null";
  }

  @Override
  public <T> T accept(ASTVisitor<T> visitor) {
    return visitor.visit(this);
  }
  
}
