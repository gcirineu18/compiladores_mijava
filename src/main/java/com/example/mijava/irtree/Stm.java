package com.example.mijava.irtree;
abstract public class Stm {
	abstract public ExpList kids();
	abstract public Stm build(ExpList kids);
	@Override
	abstract public String toString();
}

