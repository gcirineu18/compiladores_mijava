package com.example.mijava.irtree;
import com.example.mijava.temp.Temp;

import lombok.Builder;

import com.example.mijava.temp.Label;

@Builder
public class ESEQ extends ExpAbstract {
  public Stm stm;
  public ExpAbstract exp;
  public ESEQ(Stm s, ExpAbstract e) {stm=s; exp=e;}
  public ExpList kids() {throw new Error("kids() not applicable to ESEQ");}
  public ExpAbstract build(ExpList kids) {throw new Error("build() not applicable to ESEQ");}
}

