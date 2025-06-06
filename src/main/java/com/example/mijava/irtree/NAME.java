package com.example.mijava.irtree;
import com.example.mijava.temp.Temp;
import com.example.mijava.temp.Label;

public class NAME extends Exp {
  public Label label;
  public NAME(Label l) {label=l;}
  public ExpList kids() {return null;}
  public Exp build(ExpList kids) {return this;}
}

