package com.example.mijava.irtree;
import com.example.mijava.temp.Temp;
import com.example.mijava.temp.Label;
import com.example.mijava.temp.LabelList;

public class JUMP extends Stm {

  public ExpAbstract exp;
  public LabelList targets;
  public JUMP(ExpAbstract e, LabelList t) {exp=e; targets=t;}
  public JUMP(Label target) {
      this(new NAME(target), new LabelList(target,null));
  }
  public ExpList kids() {return new ExpList(exp,null);}
  public Stm build(ExpList kids) {
    return new JUMP(kids.head,targets);
  }
}

