package com.example.mijava.temp;

import com.example.mijava.utils.List;

public class TempList extends List<Temp> {
   public Temp head;
   public TempList tail;

   public TempList(Temp h, TempList t) {
    this.head = h; 
    this.tail = t;
    }
}

