package com.example.mijava.temp;

public class LabelList {
   public Label head;
   public LabelList tail;

   public LabelList(Label h, LabelList t) {
    this.head = h; 
    this.tail = t;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        LabelList current = this;
        while (current != null) {
            sb.append(current.head);
            current = current.tail;
            if (current != null) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}

