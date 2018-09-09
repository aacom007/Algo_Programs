//'main' method must be in a class 'Rextester'.
//Compiler version 1.8.0_111// 8:06
// Author: akshay anand
// dated: 090918

import java.util.*;
import java.lang.*;

class Rextester
{  
    
    public class setSort implements Comparator<Node>{
        public int compare(Node n, Node m){
            return n.val.compareTo(m.val);
        }
    }
    
    public static void main(String args[])
    {
        System.out.println("Hello, World!");
        Rextester r = new Rextester();
        ArrayList<Node> g = r.graph();    
        r.start(g, "c","f");
    }
    
    public void start(ArrayList<Node> g, String startNode, String endNode)
    {
        TreeSet<Node> ts = new TreeSet<Node>(new setSort());
        TreeSet<Node> endSet = new TreeSet<Node>(new setSort());
        Node start = new Node();
        Node end = new Node();
        
        for(Node n: g){
            if(n.val== endNode){
                end = n;
                System.out.println(end.val +" END.val");
                endSet.add(end);
            }
            if(n.val == startNode){
                start = n;
                ts.add(start);
                System.out.println(start.val +" start.val");
            }
        }
        
         
        int len =0;
        boolean flag = false;
       
        //Set<Node> set2 = Collections.synchronizedSet(endSet);
      
        while(ts.size()>0 || endSet.size()>0){
            start = ts.pollFirst();
            end = endSet.pollFirst();
           
            if(start.adj.contains(end) || end.adj.contains(start)){
                System.out.print("Found at "+ (len+1));
                break;
            }
            
            for(Node n: start.adj){
                if(!n.visited)
                    ts.add(n);
                if(endSet.contains(n)){
                    len++;
                    flag = true;
                    break;
                }
            }
            if(!flag)
                len++;
            for(Node n: end.adj){
                if(!n.visited)
                    endSet.add(n);
                if(ts.contains(n)){
                    len++;
                    flag = true;
                    break;
                }
            }
            
            if(!flag)
                len++;
            start.visited = true;
            end.visited = true;
            
            if(flag){
                System.out.println("Found at length "+ (len));
             break;
            }
        }
    }
    public ArrayList<Node> graph(){
    
        ArrayList<Node> g = new ArrayList<Node>();
        
        Node a = new Node();
        Node b = new Node();
        Node c = new Node();
        Node d = new Node();
        Node e = new Node();
        Node f = new Node();
        
        a.val = "a";
        b.val = "b";
        c.val = "c";
        d.val = "d";
        e.val = "e";
        f.val = "f";
        
        a.adj.add(b);
        a.adj.add(e);
        a.adj.add(c);
        b.adj.add(d);
        b.adj.add(a);
        d.adj.add(b);
        d.adj.add(e);
        e.adj.add(a);
        e.adj.add(d);
        c.adj.add(a);
        e.adj.add(f);
        f.adj.add(e);
        
        g.add(a);
        g.add(b);
        g.add(c);
        g.add(d);
        g.add(e);
        g.add(f);
        return g;
    }
    
    class Node{
        public String val;
        public ArrayList<Node> adj = new ArrayList<Node>();
        public boolean visited = false;
    }
    
}
