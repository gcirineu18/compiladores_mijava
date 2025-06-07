package com.example.mijava.visitor.IRTree;

import com.example.mijava.irtree.Stm;
import com.example.mijava.mips.MipsFrame;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProcFrag extends Frag{
    private Stm body;
	private MipsFrame frame;

	public ProcFrag(Stm b, MipsFrame f, Frag next) {
		super(next);
		body = b;
		frame = f;
	}
}
