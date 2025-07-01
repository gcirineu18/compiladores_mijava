package com.example.mijava.irtree;

public class StmList {
  public Stm head;
  public StmList tail;
  public StmList(Stm h, StmList t) {head=h; tail=t;}

  @Override
  public String toString() {
      StringBuilder sb = new StringBuilder();
      StmList current = this;
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



