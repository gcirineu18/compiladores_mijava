package com.example.mijava.utils;

import java.util.ArrayList;
import java.util.List;

import com.example.mijava.asem.Instr;
import com.example.mijava.asem.InstrList;
import com.example.mijava.irtree.Stm;
import com.example.mijava.irtree.StmList;
import com.example.mijava.temp.Temp;
import com.example.mijava.temp.TempList;

public class Convert {

    public static TempList ArrayToTempList(Temp array[]) {

        TempList tempList = null;

        for (int i = array.length-1; i >= 0; --i) {
            tempList = new TempList(array[i], tempList);
        }
        return tempList;
    }

     public static Temp[] TempListToArray(TempList tempList) {

        Temp array[] = new Temp[Convert.TempListToList(tempList).size()];
        TempList temp = tempList;

        for (int i = 0; i < array.length; i++) {
            array[i] = temp.head;
            temp = temp.tail;
        }

        return array;
    }

    public static List<Temp> TempListToList(TempList tempList) {

        ArrayList<Temp> list = new ArrayList<Temp>();

        TempList temp = tempList;
        while (temp != null) {
            list.add(temp.head);
            temp = temp.tail;
        }

        return list;
    }

       public static List<Instr> InstrListToArray(InstrList ht) {
        ArrayList<Instr> r = new ArrayList<Instr>();

        InstrList h = ht;
        while (h != null) {
            r.add(h.head);
            h = h.tail;
        }

        return r;
    }

        public static List<Stm> StmListToArray (StmList ht) {
        ArrayList<Stm> r = new ArrayList<Stm>();

        StmList h = ht;
        while (h != null) {
            r.add(h.head);
            h = h.tail;
        }

        return r;
    }
}
