package com.example.mijava.regAlloc;

import com.example.mijava.FlowGraph.AssemFlowGraph;
import com.example.mijava.asem.InstrList;
import com.example.mijava.frame.Frame;
import com.example.mijava.temp.Temp;
import com.example.mijava.temp.TempMap;
import com.example.mijava.utils.List;
import com.example.mijava.utils.Convert;


public class RegAlloc implements TempMap {

    public InstrList instrs;
    private Color color;

    public RegAlloc(Frame f, InstrList il, InterferenceGraph ig) {
        this.instrs = il;

        boolean done = false;
        while (!done) {

            color = new Color(ig, f, f.registers());

            List<Temp> spills = color.spills();
            if (spills == null) {
                done = true;
            } else {

                System.err.println("Spilling requisitado mas não foi implementado...");
                for (List<Temp> s = spills; s != null; s = s.tail) {
                    System.err.println("- " + s.head);
                }
                done = true;
            }
        }
    }

    public String tempMap(Temp temp) {
        return color.tempMap(temp);
    }
}