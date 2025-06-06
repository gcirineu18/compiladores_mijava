package com.example.mijava.mips;

import com.example.mijava.temp.Temp;
import com.example.mijava.frame.Access;

public class Inreg extends Access {
    Temp temp;

    InReg(Temp t) {
        this.temp = t;
    }

    public ExpAbstract exp(ExpAbstract fp) {
        return new TEMP(temp);
    }

    public String toString() {
		  return temp.toString();
	  }
}