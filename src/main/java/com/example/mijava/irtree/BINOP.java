package com.example.mijava.irtree;

public class BINOP extends ExpAbstract {
  public int binop;
  public ExpAbstract left, right;
  public BINOP(int b, ExpAbstract l, ExpAbstract r) {
    binop=b; left=l; right=r; 
  }
  public final static int PLUS=0, MINUS=1, MUL=2, DIV=3, 
		   AND=4,OR=5,LSHIFT=6,RSHIFT=7,ARSHIFT=8,XOR=9;
  public ExpList kids() {return new ExpList(left, new ExpList(right,null));}
  public ExpAbstract build(ExpList kids) {
    return new BINOP(binop,kids.head,kids.tail.head);
  }

}
