package com.example.mijava.regAlloc;

import java.util.Hashtable;

import com.example.mijava.graph.Node;
import com.example.mijava.temp.Temp;
import com.example.mijava.temp.TempMap;
import com.example.mijava.utils.List;

public class Color implements TempMap {
     Color(InterferenceGraph ig, TempMap initial, List<Temp> registers, 
            Hashtable<Node, Integer> cost)
    {
        super();
    }

    public String tempMap(Temp t)
    {
        return null;
    }

    List<Temp> spills()
    {
        return null;
    }
}
