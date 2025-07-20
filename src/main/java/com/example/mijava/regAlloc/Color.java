package com.example.mijava.regAlloc;

import java.util.Hashtable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

import com.example.mijava.graph.Node;
import com.example.mijava.temp.Temp;
import com.example.mijava.temp.TempMap;
import com.example.mijava.utils.List;


public class Color implements TempMap {
    
    private final InterferenceGraph ig;
    private final TempMap initial;
    private final Temp[] registers;
    private final Hashtable<Temp, String> allocation = new Hashtable<>();
    private List<Temp> spillList = null;


    public Color(InterferenceGraph ig, TempMap initial, Temp[] registers) {
        this.ig = ig;
        this.initial = initial;
        this.registers = registers;

        int K = 0;
        for (int  r = 0; r < this.registers.length; r ++) {
          K++;
        }
        color(K);
    }
    

    private void color(int K) {

        HashSet<Node> precolored = new HashSet<>();
        HashSet<Node> initial_nodes = new HashSet<>();
        Stack<Node> simplifyWorklist = new Stack<>();
        Stack<Node> selectStack = new Stack<>();
        
        // Idenficando os nós pré-coloridos
        for (List<Node> nodes = ig.nodes(); nodes != null; nodes = nodes.tail) {
            Node n = nodes.head;
            Temp t = ig.gtemp(n);
            if (t != null) {
                initial_nodes.add(n);

                if (initial != null && initial.tempMap(t) != null) {
                    System.out.println("Nó pre colorido: " + n);
                    precolored.add(n);
                }
            }
        }
        
        buildWorklist(initial_nodes, precolored, simplifyWorklist, K);
        
        while (!simplifyWorklist.isEmpty()) {
            Node n = simplifyWorklist.pop();
            selectStack.push(n);
            
            // Remove o nó e atualiza o número de vizinhos
            for (com.example.mijava.utils.List<Node> adj = n.adj(); adj != null; adj = adj.tail) {
                Node m = adj.head;
                if (initial_nodes.contains(m) && !precolored.contains(m)) {
                    decrementDegree(m, initial_nodes, precolored, simplifyWorklist, K);
                }
            }
            initial_nodes.remove(n);
        }
        
        // Pode haver casos em que o spill, é necessário...

        java.util.List<Temp> spills = new ArrayList<>();
        for (Node n : initial_nodes) {
            if (!precolored.contains(n)) {
                Temp t = ig.gtemp(n);
                if (t != null) {
                    spills.add(t);
                }
                selectStack.push(n);
            }
        }
        
        if (!spills.isEmpty()) {
            spillList = listFromJavaList(spills);
        }
        
        // Atribuindo as cores
        while (!selectStack.isEmpty()) {
            Node n = selectStack.pop();
            Temp t = ig.gtemp(n);
            if (t == null) continue;
            
            if (initial != null && initial.tempMap(t) != null) {
                allocation.put(t, initial.tempMap(t));
                continue;
            }

            HashSet<String> forbidden = new HashSet<>();
            for (com.example.mijava.utils.List<Node> adj = n.adj(); adj != null; adj = adj.tail) {
                Temp adjTemp = ig.gtemp(adj.head);
                if (adjTemp != null) {
                    String color = allocation.get(adjTemp);
                    if (color != null) {
                        forbidden.add(color);
                    }
                }
            }
            
            // Procurando por cor disponível
            String chosenColor = null;
            for (int  r = 0 ; r <  registers.length; r ++) {

               String regName = initial.tempMap(registers[r]);
                if (!forbidden.contains(regName)) {
                    chosenColor = regName;
                    break;
                }
                
            }
            
            if (chosenColor != null) {
                allocation.put(t, chosenColor);
            }
        }
    }
    
    private void buildWorklist(HashSet<Node> nodes, HashSet<Node> precolored, 
                              Stack<Node> simplifyWorklist, int K) {
        for (Node n : nodes) {
            if ( !precolored.contains(n) && degree(n, nodes) < K) {
                simplifyWorklist.push(n);
            }
        }
    }
    
    private void decrementDegree(Node n, HashSet<Node> nodes, HashSet<Node> precolored,
                                Stack<Node> simplifyWorklist, int K) {
        if (degree(n, nodes) == K) {

            if (!precolored.contains(n)) {
                simplifyWorklist.push(n);
            }
        }
    }
    
    private int degree(Node n, HashSet<Node> activeNodes) {
        int deg = 0;
        for (com.example.mijava.utils.List<Node> adj = n.adj(); adj != null; adj = adj.tail) {
            if (activeNodes.contains(adj.head)) {
                deg++;
            }
        }
        return deg;
    }
    
    private List<Temp> listFromJavaList(java.util.List<Temp> javaList) {
        List<Temp> result = null;
        for (int i = javaList.size() - 1; i >= 0; i--) {
            result = new List<>(javaList.get(i), result);
        }
        return result;
    }
    
    @Override
    public String tempMap(Temp t) {
        return allocation.get(t);
    }
    
    public List<Temp> spills() {
        return spillList;
    }
}
