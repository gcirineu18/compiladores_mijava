package com.example.mijava.temp;
import com.example.mijava.symbol.SymbolEntry;

public class Label {
    private String name;
    private static int count;

    public Label() {
        this("L" + count++);
    }

    public Label(String n) {
        this.name = n;
    }

    public Label(SymbolEntry s) {
        this(s.toString());
    }

    public String toString() {
        return name;
    }
}