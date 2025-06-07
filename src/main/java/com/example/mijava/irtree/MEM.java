package com.example.mijava.irtree;
import com.example.mijava.temp.Temp;
import com.example.mijava.temp.Label;

public class MEM extends ExpAbstract {
  public ExpAbstract exp;
  public MEM(ExpAbstract e) {exp=e;}
  public ExpList kids() {return new ExpList(exp,null);}
  public ExpAbstract build(ExpList kids) {
    return new MEM(kids.head);
  }
}

