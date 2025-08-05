package com.example.mijava.FlowGraph;

import java.util.Hashtable;

import com.example.mijava.asem.AssemLABEL;
import com.example.mijava.asem.AssemMOVE;
import com.example.mijava.asem.Instr;
import com.example.mijava.asem.InstrList;
import com.example.mijava.graph.Node;
import com.example.mijava.irtree.MOVE;
import com.example.mijava.temp.Label;
import com.example.mijava.temp.LabelList;
import com.example.mijava.temp.TempList;
import com.example.mijava.utils.List;

public class AssemFlowGraph extends FlowGraph {
    private Hashtable<Node, Instr> map;
    private Hashtable<Instr, Node> revMap;
    Hashtable <Label, Instr> map1;
    Hashtable <Instr, Label> revMap1;
        
    public AssemFlowGraph(InstrList list)
    {
        super();
        
        map = new Hashtable<Node, Instr>();
        revMap = new Hashtable<Instr, Node>();
        map1 = new Hashtable<Label, Instr>();
        revMap1 = new Hashtable<Instr,Label>();
        
        buildGraph(list);
    }
        
    private void buildGraph(InstrList ilist){ 

        Instr aux_label = null, aux_branch = null;
        for( InstrList a = ilist ; a != null; a = (InstrList) a.tail ){
            if ( a.head instanceof AssemLABEL ){
                aux_label = a.head;
               
        	} else{
                Node n = this.newNode();
        		map.put(n, a.head);            
        		revMap.put(a.head, n);     
        		if(aux_label!=null){ 
                    map1.put((( AssemLABEL)aux_label).label, a.head );
                    
        			revMap1.put( a.head, (( AssemLABEL)aux_label).label);
        			aux_label = null;
        		}
            }
        }
        for ( InstrList aux = ilist; aux != null; aux = (InstrList) aux.tail ){
            if(!(aux.head instanceof  AssemLABEL)){
                
                LabelList jmps = aux.head.jumps; 
        		
	            if ( jmps == null ){

                    if (aux.tail != null){

                        if(!(aux.tail.head instanceof  AssemLABEL)) {
                            this.addEdge(revMap.get(aux.head), revMap.get(aux.tail.head));
                        } else  {
                            
                            try {
                                this.addEdge(revMap.get(aux.head), revMap.get(map1.get((( AssemLABEL)aux.tail.head).label)));
                            } catch (Exception e) {
                                // TODO: handle exception
               //                 System.out.println("Exceção: " +  e +  "\n");
                                
                            }

                        };
                        
	                } 
	            }
	            else{

	                for ( LabelList a = jmps; a != null; a = (LabelList) a.tail ){
                        
                        if(revMap1.contains(a.head)){
                            this.addEdge(revMap.get(aux.head), revMap.get(map1.get(a.head)));
	                		//System.out.println("add "+revMap.get(aux.head).toString()+"->"+revMap.get(map1.get(a.head)).toString());
	                	}
	                }
	            }


	            
	            // para o caso de instru��o branch
	            if(aux_branch!=null){
                    this.addEdge(revMap.get(aux_branch), revMap.get(aux.head));
	            	aux_branch = null;
	            }
	            
	            //if(aux.head.branch) aux_branch = aux.head;
	            
        	}
        }        
    }

    
    public Instr instr(Node node)
    {
        return map.get(node);
    }
    
    public Node node(Instr instr)
    {
        return revMap.get(instr);
    }

    public TempList def(Node node)
    {
        Instr i = map.get(node);
        
        if ( i == null )
            return null;
        
        return i.def();
    }

    public TempList use(Node node)
    {
        Instr i = map.get(node);
        
        if ( i == null )
            return null;
        
        return i.use();
    }

    public boolean isMove(Node node)
    {
        Instr i = map.get(node);
        
        if ( i == null )
            return false;
        
        return i instanceof AssemMOVE;
    }
    
    public void print()
    {
        for (List<Node> p=nodes(); p!=null; p=p.tail)
        {
            Node n = p.head;
            System.out.print(n.toString());
            if(map1.contains(map.get(n)))System.out.print("["+revMap1.get(map.get(n)).toString()+"]");
            System.out.print("["+ map.get(n).assem +"]: ");
            for(List<Node> q=n.succ(); q!=null; q=q.tail)
            {
            	System.out.print(q.head.toString());
            	System.out.print(" ");
            }
            
            // /*System.out.println();
            // System.out.print("USE:");
			// for(TempList aux = this.use(n); aux != null; aux = (TempList) aux.tail){
			// 	if(aux.head != null) System.out.print(aux.head.toString()+ " ");
			// }
			
			// System.out.println();
            // System.out.print("DEF:");
			// for(TempList aux = this.def(n); aux != null; aux = (TempList) aux.tail){
			// 	if(aux.head != null) System.out.print(aux.head.toString()+ " ");
			// }*/
            System.out.println();
        }
    }
}
