package com.example.mijava.mips;

import org.apache.tomcat.util.bcel.Const;

import com.example.mijava.frame.Access;

public class InFrame extends Access {
  int offset;

  public InFrame(int o) {
    this.offset = o;
  }

  public ExpAbstract exp(ExpAbstract fp) {
    return new MEM(new BINOP(BINOP.PLUS, fp, new CONST(offset)));
  }

  public String toString() {
    return Integer.toString(this.offset);
  }
}

