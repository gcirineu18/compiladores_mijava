package com.example.mijava.temp;

public class CombineMap implements TempMap {
  TempMap tmap1, tmap2;
  
  public String tempMap(Temp t) {
	   String s = tmap1.tempMap(t);

	   if (s!=null) return s;

	   return tmap2.tempMap(t);
	}

	public CombineMap(TempMap t1, TempMap t2) {
	  this.tmap1 = t1;
    this.tmap2 = t2;
	}

}