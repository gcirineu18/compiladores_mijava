package com.example.mijava.irtree;


public abstract class ExpAbstract {
  public abstract ExpList children();
  public abstract ExpAbstract build(ExpList children);
}
