package com.example.mijava.mips;

import com.example.mijava.asem.InstrList;
import com.example.mijava.irtree.Stm;

public interface MipsCodegen {
    InstrList codegen(Stm stm);
}
