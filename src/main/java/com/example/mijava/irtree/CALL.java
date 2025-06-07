package com.example.mijava.irtree;

import com.example.mijava.temp.Temp;

import lombok.Builder;

import com.example.mijava.temp.Label;

@Builder
public class CALL extends ExpAbstract {

  public ExpAbstract func;
  public ExpList args;

  public CALL(ExpAbstract f, ExpList a) {
    func = f;
    args = a;
  }

  public ExpList kids() {
    return new ExpList(func, args);
  }

  public ExpAbstract build(ExpList kids) {
    return new CALL(kids.head, kids.tail);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("CALL(");
    sb.append(func != null ? func.toString() : "null");
    ExpList a = args;
    while (a != null && a.head != null) {
      sb.append(", ");
      sb.append(a.head.toString());
      a = a.tail;
    }
    sb.append(")");
    return sb.toString();
  }
}
