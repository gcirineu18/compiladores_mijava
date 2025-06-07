package com.example.mijava.irtree;


public abstract class ExpAbstract {
  public abstract ExpList kids();
  public abstract ExpAbstract build(ExpList kids);
}
