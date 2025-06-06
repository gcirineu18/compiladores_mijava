package com.example.mijava.mips;

import org.apache.tomcat.util.bcel.Const;

import com.example.mijava.frame.Access;
import com.example.mijava.irtree.BINOP;
import com.example.mijava.irtree.MEM;
import com.example.mijava.irtree.CONST;
import com.example.mijava.irtree.Exp;

public class InFrame extends Access {
  int offset;

  public InFrame(int o) {
    this.offset = o;
  }

  public Exp exp(Exp fp) {
    return new MEM(new BINOP(BINOP.PLUS, fp, new CONST(offset)));
  }

  public String toString() {
    return Integer.toString(this.offset);
 
  }
}

