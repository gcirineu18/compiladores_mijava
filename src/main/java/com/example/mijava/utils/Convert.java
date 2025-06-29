package com.example.mijava.utils;

import java.util.ArrayList;
import java.util.List;

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
}
