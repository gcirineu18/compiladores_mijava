package com.example.mijava.asem;

import com.example.mijava.temp.Label;
import com.example.mijava.temp.TempList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@NoArgsConstructor
public class AssemLABEL extends Instr{

  public Label label;

  public AssemLABEL(String a, Label l){
      assem = a;
      label = l;
    }

  public TempList use() {
        return null;
    }

	public TempList def() {
		return null;
	}

	public Targets jumps() {
		return null;
	}
    
}
