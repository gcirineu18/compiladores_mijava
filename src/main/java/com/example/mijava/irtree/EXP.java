package com.example.mijava.irtree;

import com.example.mijava.temp.Temp;
import com.example.mijava.temp.Label;

public class EXP extends Stm {
  public ExpAbstract exp;

  public EXP(ExpAbstract e) {
    exp = e;
  }

  public ExpList kids() {
    return new ExpList(exp, null);
  }

  public Stm build(ExpList kids) {
    return new EXP(kids.head);
  }

  @Override
  public String toString() {
    return "EXP(" + (exp != null ? exp.toString() : "null") + ")";
  }
}
