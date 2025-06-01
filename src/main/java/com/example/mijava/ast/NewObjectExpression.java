package com.example.mijava.ast;

import com.example.mijava.symbol.SymTabScopeNode;
import com.example.mijava.visitor.ASTVisitor;

public class NewObjectExpression extends Expression {
    
  private Id id;

	NewObjectExpression(int line, int column){
		super(line, column);
	}

	public NewObjectExpression(Id id){
		this.id = id;
	};

	 @Override
		public String printNode() {
				return "NewObject ( " + id.printNode() + " ) ";
		}
		@Override
		public void createSymTab(SymTabScopeNode curScope) {}
		@Override
		public String typeCheck(SymTabScopeNode curScope) {
				if(!mainScope.next.containsKey(id.getS())){
					semanticErrorNumber++;
					semanticErrorMsg.add(id.getTypeErr(semanticErrorNumber, "Type Error in New Object Expression", id.getS(), "Not exist class name"));
				}
				return id.getS();
		}
	
  @Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}
}
