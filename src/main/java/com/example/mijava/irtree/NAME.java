package com.example.mijava.irtree;
import com.example.mijava.temp.Temp;
import com.example.mijava.temp.Label;

public class NAME extends ExpAbstract {
  public Label label;
  public NAME(Label l) {label=l;}
  public ExpList kids() {return null;}
  public ExpAbstract build(ExpList kids) {return this;}
}

