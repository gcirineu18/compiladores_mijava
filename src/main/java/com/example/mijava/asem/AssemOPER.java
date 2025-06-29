package com.example.mijava.asem;

import com.example.mijava.temp.LabelList;
import com.example.mijava.temp.TempList;

public class AssemOPER extends Instr{
    
    public TempList dst;
	public TempList src;
	public Targets jump;

	public AssemOPER(String a, TempList d, TempList s, LabelList j) {
		assem = a;
		dst = d;
		src = s;
		jump = new Targets(j);
	}

	public AssemOPER(String a, TempList d, TempList s) {
		assem = a;
		dst = d;
		src = s;
		jump = null;
	}

	public TempList use() {
		return src;
	}

	public TempList def() {
		return dst;
	}

	public Targets jumps() {
		return jump;
	}

}
