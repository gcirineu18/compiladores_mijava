package com.example.mijava.frame;

// import com.example.mijava.assem.Instr;
// import com.example.mijava.assem.InstrList;
import com.example.mijava.irtree.ExpAbstract;
import com.example.mijava.irtree.Stm;
import com.example.mijava.irtree.StmList;
import com.example.mijava.temp.Label;
import com.example.mijava.temp.Temp;
import com.example.mijava.temp.TempMap;

import java.util.List;

public abstract class Frame implements TempMap {
	public Label name;
	public List<Access> formals;

	public abstract Frame newFrame(String name, List<Boolean> formals);

	public abstract Access allocLocal(boolean escape);

	public abstract Temp FP();

	public abstract int wordSize();

	public abstract ExpAbstract externalCall(String func, List<ExpAbstract> args);

	public abstract Temp RV();

	public abstract String string(Label label, String value);

	public abstract Label badPtr();

	public abstract Label badSub();

	public abstract String tempMap(Temp temp);

	// public abstract InstrList codegen(StmList stms);

	public abstract void procEntryExit1(List<Stm> body);
	
	// public abstract void procEntryExit2(List<Assem.Instr> body);

  // public abstract void procEntryExit3(List<Assem.Instr> body);

	public abstract Temp[] registers();

	// public abstract void spill(InstrList insns, Temp[] spills);

	public abstract String programTail();


	
        

}