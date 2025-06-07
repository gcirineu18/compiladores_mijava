package com.example.mijava.irtree;

import com.example.mijava.temp.Temp;
import com.example.mijava.temp.Label;

public class CONST extends ExpAbstract {
  public int value;

  public CONST(int v) {
    value = v;
  }

  public ExpList kids() {
    return null;
  }

  public ExpAbstract build(ExpList kids) {
    return this;
  }

  @Override
  public String toString() {
    return "CONST(" + value + ")";
  }
}
