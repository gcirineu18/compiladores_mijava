package com.example.mijava.irtree;


public abstract class Exp {
  public abstract ExpList kids();
  public abstract Exp build(ExpList kids);
}
