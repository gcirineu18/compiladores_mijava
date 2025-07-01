package com.example.mijava.irtree;
import com.example.mijava.temp.Temp;
import com.example.mijava.temp.Label;

public class LABEL extends Stm { 
  public Label label;
  public LABEL(Label l) {label=l;}
  public ExpList kids() {return null;}
  public Stm build(ExpList kids) {
    return this;
  }

  @Override
  public String toString() {
      return "LABEL " + label.toString();
  }
}

