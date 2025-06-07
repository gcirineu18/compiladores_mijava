package com.example.mijava.mips;

import com.example.mijava.temp.Temp;
import com.example.mijava.irtree.TEMP;
import com.example.mijava.frame.Access;
import com.example.mijava.irtree.ExpAbstract;

public class InReg extends Access {
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