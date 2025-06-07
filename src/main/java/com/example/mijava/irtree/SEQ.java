package com.example.mijava.irtree;
import com.example.mijava.temp.Temp;

import lombok.Builder;

import com.example.mijava.temp.Label;

@Builder
public class SEQ extends Stm {
  public Stm left, right;
  public SEQ(Stm l, Stm r) { left=l; right=r; }
  public ExpList kids() {throw new Error("kids() not applicable to SEQ");}
  public Stm build(ExpList kids) {throw new Error("build() not applicable to SEQ");}
}

