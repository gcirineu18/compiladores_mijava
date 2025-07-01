package com.example.mijava.irtree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpList {
    public ExpAbstract head;
    public ExpList tail;

    @Override
    public String toString() {
        if (head == null)
            return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ExpList curr = this;
        while (curr != null && curr.head != null) {
            sb.append(curr.head.toString());
            if (curr.tail != null && curr.tail.head != null)
                sb.append(", ");
            curr = curr.tail;
        }
        sb.append("]");
        return sb.toString();
    }
}