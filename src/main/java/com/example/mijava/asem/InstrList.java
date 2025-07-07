package com.example.mijava.asem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@NoArgsConstructor
public class InstrList {
    public Instr head;
    public InstrList tail;
}
