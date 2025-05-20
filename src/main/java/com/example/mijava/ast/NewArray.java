package com.example.mijava.ast;

public class NewArray extends Expression {
    private Expression e;

    @Override
	public <T> T accept(Visitor<T> v) {
		return v.visit(this);
	}
}
