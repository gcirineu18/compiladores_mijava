package com.example.mijava.mips;

import java.util.List;

import com.example.mijava.asem.AssemLABEL;
import com.example.mijava.asem.AssemMOVE;
import com.example.mijava.asem.AssemOPER;
import com.example.mijava.asem.Instr;
import com.example.mijava.asem.InstrList;
import com.example.mijava.frame.Frame;
import com.example.mijava.irtree.BINOP;
import com.example.mijava.irtree.CALL;
import com.example.mijava.irtree.CJUMP;
import com.example.mijava.irtree.CONST;
import com.example.mijava.irtree.EXP;
import com.example.mijava.irtree.ExpAbstract;
import com.example.mijava.irtree.ExpList;
import com.example.mijava.irtree.JUMP;
import com.example.mijava.irtree.LABEL;
import com.example.mijava.irtree.MEM;
import com.example.mijava.irtree.MOVE;
import com.example.mijava.irtree.NAME;
import com.example.mijava.irtree.SEQ;
import com.example.mijava.irtree.Stm;
import com.example.mijava.irtree.TEMP;
import com.example.mijava.temp.Label;
import com.example.mijava.temp.LabelList;
import com.example.mijava.temp.Temp;
import com.example.mijava.temp.TempList;
import com.example.mijava.visitor.IRTree.Exp;

import lombok.Data;

@Data
public class Codegen implements MipsCodegen {

    Frame frame;
    public InstrList ilist = null, last = null;
    
    public Codegen(Frame f) {
        frame = f;
    }

    public void emit(Instr inst) {
        if (last != null)
            last = last.tail = new InstrList(inst, null);
        else
            last = ilist = new InstrList(inst, null);
    }

    public void munchStm(Stm s) {
        if (s instanceof SEQ) {
            munchStm(((SEQ) s).left);
            munchStm(((SEQ) s).right);
        }
        if (s instanceof MOVE)
            munchMove(((MOVE) s).dst, ((MOVE) s).src);
        if (s instanceof LABEL)
            emit(new AssemLABEL( (((LABEL) s).label) + ":\n", ((LABEL) s).label));
        if (s instanceof JUMP)
            munchJump((JUMP) s);
        if (s instanceof CJUMP)
            munchCJump((CJUMP) s);
        if (s instanceof EXP) {
            if( ((EXP)s).exp instanceof CALL)
            {
                Temp r = munchExp(((CALL) (((EXP) s).exp)).func);
                TempList l = munchArgs(0, ((CALL) (((EXP) s).exp)).args);
                emit(new AssemOPER("jal " + ((NAME)((CALL) (((EXP) s).exp)).func).label + "\n",
                        null, new TempList(r, l)));
            }
        }
    }

    Temp munchExp(ExpAbstract s) {
        if (s instanceof MEM)
            return munchMem((MEM) s);
        if (s instanceof CONST) {
            Temp r = new Temp();
            emit(new AssemOPER("addi "+r +",  r0, " + ((CONST) s).value
                    + "\n", new TempList(r, null), null));
            return r;
        }
        if (s instanceof BINOP)
            return munchBinop((BINOP) s);
        if (s instanceof TEMP)
            return ((TEMP) s).temp;
        if( s instanceof NAME)
            return new Temp();
        return null;
    }

    private TempList munchArgs(int i, ExpList args) {
        ExpList temps = args;
        TempList retorno = null;
        while (temps != null) {
            Temp x = munchExp(temps.head);
            retorno = new TempList(x,retorno);
            temps = temps.tail;
        }
        return retorno;
    }

    private void munchCJump(CJUMP s) {
        Temp r = munchExp(new BINOP(BINOP.MINUS, s.left, s.right));
        if (s.relop == CJUMP.EQ) {
            emit(new AssemOPER("beq " + r + ", 0, " + s.iftrue+"\n",
                    null, new TempList(r, null), new LabelList(
                    s.iftrue, null)));
        } else if (s.relop == CJUMP.GE) {
            emit(new AssemOPER("bge " + r + ", 0, " + s.iftrue+"\n",
                    null, new TempList(r, null), new LabelList(
                    s.iftrue, null)));
        } else if (s.relop == CJUMP.LT) {
            emit(new AssemOPER("blt " + r + ", 0, " + s.iftrue+"\n",
                    null, new TempList(r, null), new LabelList(
                    s.iftrue, null)));
        } else if (s.relop == CJUMP.NE) {
            emit(new AssemOPER("bne " + r + ", 0, " + s.iftrue+"\n",
                    null, new TempList(r, null), new LabelList(
                    s.iftrue, null)));
        }
        else if (s.relop == CJUMP.GT) {
            emit(new AssemOPER("bgt " + r + ", 0, " + s.iftrue+"\n",
                    null, new TempList(r, null), new LabelList(
                    s.iftrue,null)));
        }
        else
            emit(new AssemOPER("j " + s.iffalse.toString()+"\n", null, null,
                    new LabelList(s.iffalse, null)));
    }

    private void munchJump(JUMP s) {
        emit(new AssemOPER("jr " + ((NAME) s.exp).label.toString() + "\n",
                null, null, new LabelList(((NAME) s.exp).label, null)));
    }

    void munchMove(MEM dst, ExpAbstract src) {
        if (dst.exp instanceof BINOP && ((BINOP) dst.exp).binop == BINOP.PLUS
                && ((BINOP) dst.exp).right instanceof CONST) {
            TempList destino = new TempList(
                    munchExp(((BINOP) dst.exp).left), null);

            TempList fonte = new TempList(munchExp(src), null);

            emit(new AssemOPER("sw" + fonte.head  + ", " + ((CONST) ((BINOP) dst.exp).right).value
                    + "( add s0, " + frame.FP() + "," + destino.head + ")\n", destino, fonte));

            
        }
        else if (dst.exp instanceof BINOP
                && ((BINOP) dst.exp).binop == BINOP.PLUS
                && ((BINOP) dst.exp).left instanceof CONST) {
            Temp r = new Temp();
            TempList destino = new TempList(
                    munchExp(((BINOP) dst.exp).right), null);

            TempList fonte = new TempList(munchExp(src), null);

            emit(new AssemOPER("add " + r + ", " + frame.FP() + ", " + destino.head + "\n", new TempList(r, null), destino));
            emit(new AssemOPER("sw " + fonte.head + ", " + ((CONST) ((MEM) dst.exp).exp).value + " (" + r +")\n", destino, fonte));
        }

        else if (dst.exp instanceof MEM && ((MEM) dst.exp).exp instanceof CONST) {
            Temp r = new Temp();
            TempList destino = new TempList(munchExp(dst.exp), null);
            TempList fonte = new TempList(munchExp(src), null);

           /*  emit(new AssemOPER("2 M[" + frame.FP() + " + "
                    + ((CONST) ((MEM) dst.exp).exp).cnst + "] <- "
                    + fonte.head+"\n", destino, fonte, null)); */
            
            emit(new AssemOPER("add " + r + ", " + frame.FP() + ", " + destino.head + "\n", new TempList(r, null), destino));
            emit(new AssemOPER("sw " + fonte.head + ", " + ((CONST) ((MEM) dst.exp).exp).value + " (" + r +")\n", destino, fonte));
        }

        else {
            Temp r = new Temp();
            TempList destino = new TempList(munchExp(dst.exp), null);
            TempList fonte = new TempList(munchExp(src), null);

            emit(new AssemOPER("add " + r + ", " + frame.FP() + ", " + destino.head + "\n", new TempList(r, null), destino));
            emit(new AssemOPER("sw " + fonte.head + ", 0 (" + r +")\n", destino, fonte));
        }

    }

    void munchMove(TEMP dst, ExpAbstract src) {
        Temp t = munchExp(src);
        emit(new AssemMOVE("move " + dst.temp+ ", " + t+"\n", dst.temp, t));
    }

    void munchMove(ExpAbstract dst, ExpAbstract src) {

        // MOVE(d, e)
        if (dst instanceof MEM)
            munchMove((MEM) dst, src);
        if (dst instanceof TEMP && src instanceof CALL) {
            Temp r = munchExp(((CALL) src).func);
            TempList l = munchArgs(0, ((CALL) src).args);
            emit(new AssemOPER("jal " + ((NAME)((CALL) src).func).label + "\n",
                    new TempList(r,null), l));
        } else if (dst instanceof TEMP)
            munchMove((TEMP) dst, src);
    }

    private Temp munchBinop(BINOP s) {
        // munchExp(BINOP(PLUS,e1,CONST (i)))
        if (s.binop == BINOP.PLUS && s.right instanceof CONST) {
            Temp r = new Temp();
            TempList fonte = new TempList(munchExp(s.left), null);
            emit(new AssemOPER("addi "+ r + ", " + fonte.head + ", "
                    + ((CONST) s.right).value + "\n",
                    new TempList(r, null), fonte));
            return r;

        }

        // munchExp(BINOP(PLUS,CONST (i),e1))
        if (s.binop == BINOP.PLUS && s.left instanceof CONST) {
            Temp r = new Temp();
            TempList fonte = new TempList(munchExp(s.right), null);
            emit(new AssemOPER("addi "+ r + ", "  + fonte.head + ", "
                    + ((CONST) s.left).value + "\n",
                    new TempList(r, null), fonte));
            return r;

        }

        // munchExp(BINOP(PLUS,e1,e2))
        if (s.binop == BINOP.PLUS) {
            Temp r = new Temp();
            TempList fonte = new TempList(munchExp(s.left),
                    new TempList(munchExp(s.right), null));
            emit(new AssemOPER("add "+ r + ", " + fonte.head + ", "
                    + fonte.tail.head + "\n", new TempList(r, null), fonte));
            return r;
        }

        // munchExp(BINOP(MUL,e1,e2))
        if (s.binop == BINOP.MUL) {
            Temp r = new Temp();
            TempList fonte = new TempList(munchExp(s.left),
                    new TempList(munchExp(s.right), null));
            emit(new AssemOPER("mult "+ r + ", " + fonte.head + ", "
                    + fonte.tail.head + "\n", new TempList(r, null), fonte));
            return r;
        }

        // munchExp(BINOP(DIV,e1,e2))
        if (s.binop == BINOP.DIV) {
            Temp r = new Temp();
            TempList fonte = new TempList(munchExp(s.left),
                    new TempList(munchExp(s.right), null));
            emit(new AssemOPER("div "+ r + ", " + fonte.head + ", "
                    + fonte.tail.head + "\n", new TempList(r, null), fonte));
            return r;
        }

        // munchExp(BINOP(SUB,e1,CONST(i)))
        if (s.binop == BINOP.MINUS && s.right instanceof CONST) {
            Temp r = new Temp();
            TempList fonte = new TempList(munchExp(s.left),null);
            emit(new AssemOPER("subi "+ r + ", " + fonte.head + ", "
                    + ((CONST) s.right).value + "\n",
                    new TempList(r, null), fonte));
            return r;

        }

        // munchExp(BINOP(SUB,e1,e2))
        if (s.binop == BINOP.MINUS) {
            Temp r = new Temp();
            TempList fonte = new TempList(munchExp(s.left),
                    new TempList(munchExp(s.right), null));
            emit(new AssemOPER("sub "+r +", " + fonte.head + ", "
                    + fonte.tail.head + "\n", new TempList(r, null), fonte));
            return r;
        }

        return null;
    }

    private Temp munchMem(MEM s) {

        // munchExp(MEM(BINOP(PLUS,e1,CONST(i))))
        if (s.exp instanceof BINOP
                && (((BINOP) s.exp).binop == BINOP.PLUS)
                && ((BINOP) s.exp).right instanceof CONST) {
            Temp r = new Temp();
            emit(new AssemOPER(
                    "lw "+ r +", "
                            + ((CONST) (((BINOP) s.exp).right)).value
                            + "(s0)\n",
                    new TempList(r, null),
                    new TempList(munchExp(((BINOP) s.exp).left), null)));
            return r;

        }

        // munchExp(MEM(BINOP(PLUS,CONST(i),e1)))
        if (s.exp instanceof BINOP
                && (((BINOP) s.exp).binop == BINOP.PLUS)
                && ((BINOP) s.exp).left instanceof CONST) {
            Temp r = new Temp();
            emit(new AssemOPER("lw "+r + ", "
                    + ((CONST) (((BINOP) s.exp).left)).value + "(s0)\n",
                    new TempList(r, null), new TempList(
                    munchExp(((BINOP) s.exp).right), null)));
            return r;

        }

        // munchExp(MEM(CONST (i)))
        if (s.exp instanceof CONST) {
            Temp r = new Temp();
            emit(new AssemOPER("lw "+r+ ", " + ((CONST) s.exp).value
                    + "(r0)\n", new TempList(r, null), null));
            return r;
        }

        // munchExp(MEM(e1))
        Temp r = new Temp();
        emit(new AssemOPER("lw "+ r +",0(s0)\n",
                new TempList(r, null), new TempList(munchExp(s.exp),
                null)));
        return r;

    }

    public InstrList codegen(Stm s) {
        InstrList l;
        munchStm(s);
        l = ilist;
        ilist = last = null;
        return l;
    }

    public InstrList codegen(List<Stm> stms) {
        InstrList first=null, last=null;
        for (int i = 0; i < stms.size(); ++i) {
            InstrList inst = codegen(stms.get(i));
            if (last == null) {
                first = last = inst;
            } else {
                while (last.tail != null) {
                    last = last.tail;
                }
                last = last.tail = inst;
            }
        }

        return first;
    }
}
