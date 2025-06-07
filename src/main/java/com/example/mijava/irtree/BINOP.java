package com.example.mijava.irtree;

import lombok.Builder;
import lombok.Data;

@Builder
public class BINOP extends ExpAbstract {
  public int binop;
  public ExpAbstract left, right;

  public BINOP(int b, ExpAbstract l, ExpAbstract r) {
    binop = b;
    left = l;
    right = r;
  }

  public final static int PLUS = 0, MINUS = 1, MUL = 2, DIV = 3,
      AND = 4, OR = 5, LSHIFT = 6, RSHIFT = 7, ARSHIFT = 8, XOR = 9;

  public ExpList kids() {
    return new ExpList(left, new ExpList(right, null));
  }

  public ExpAbstract build(ExpList kids) {
    return new BINOP(binop, kids.head, kids.tail.head);
  }

  @Override
  public String toString() {
    String op;
    switch (binop) {
      case PLUS:
        op = "PLUS";
        break;
      case MINUS:
        op = "MINUS";
        break;
      case MUL:
        op = "MUL";
        break;
      case DIV:
        op = "DIV";
        break;
      case AND:
        op = "AND";
        break;
      case OR:
        op = "OR";
        break;
      case LSHIFT:
        op = "LSHIFT";
        break;
      case RSHIFT:
        op = "RSHIFT";
        break;
      case ARSHIFT:
        op = "ARSHIFT";
        break;
      case XOR:
        op = "XOR";
        break;
      default:
        op = "UNKNOWN";
        break;
    }
    return "BINOP(" + op + ", " + (left != null ? left.toString() : "null") + ", "
        + (right != null ? right.toString() : "null") + ")";
  }
}
