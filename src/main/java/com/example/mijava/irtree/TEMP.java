package com.example.mijava.irtree;

import com.example.mijava.temp.Temp;

public class TEMP extends ExpAbstract {
  public Temp temp;
  public TEMP(Temp t) {this.temp = t;}
  public ExpList kids() {return null;}
  public ExpAbstract build(ExpList kids) {return this;}

  @Override
  public String toString() {
      return "TEMP " + temp;
  }
}

