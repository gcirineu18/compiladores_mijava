package com.example.mijava.irtree;

import com.example.mijava.temp.Temp;

public class TEMP extends Exp {
  public Temp temp;
  public TEMP(Temp t) {this.temp = t;}
  public ExpList kids() {return null;}
  public Exp build(ExpList kids) {return this;}
}

