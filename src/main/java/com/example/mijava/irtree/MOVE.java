package com.example.mijava.irtree;
import com.example.mijava.temp.Temp;

import lombok.Builder;

import com.example.mijava.temp.Label;


@Builder
public class MOVE extends Stm {

  public ExpAbstract dst, src;

  public MOVE(ExpAbstract d, ExpAbstract s) {dst=d; src=s;}
  public ExpList kids() {
        if (dst instanceof MEM)
	   return new ExpList(((MEM)dst).exp, new ExpList(src,null));
	else return new ExpList(src,null);
  }
  public Stm build(ExpList kids) {
        if (dst instanceof MEM)
	   return new MOVE(new MEM(kids.head), kids.tail.head);
	else return new MOVE(dst, kids.head);
  }

  @Override
  public String toString() {
      return "MOVE(" + dst + ", " + src + ")";
  }
}

