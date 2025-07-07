package com.example.mijava.asem;

import com.example.mijava.temp.Temp;
import com.example.mijava.temp.TempList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@NoArgsConstructor
public class AssemMOVE extends Instr {

    public Temp dst;
	public Temp src;

	public AssemMOVE(String a, Temp d, Temp s) {
		assem = a;
		dst = d;
		src = s;
	}

	public TempList use() {
		return new TempList(src, null);
	}

	public TempList def() {
		return new TempList(dst, null);
	}

	public Targets jumps() {
		return null;
	}
}
