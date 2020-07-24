//'main' method must be in a class 'Rextester'.
//Compiler version 1.8.0_111
// Author Akshay Anand
import java.util.*;
import java.lang.*;

class Rextester
{  
   
   public static void main(String args[])
    {
        System.out.println("Hello, World!");
        Rextester k = new Rextester();
       Node root = k.makeSampleTreeA();
       
       Node start = k.createNode('b');
       Node end = k.createNode('i');
    
       while((k.isNodeOn(start,root.left) && k.isNodeOn(end,root.left)) || (k.isNodeOn(start,root.right) && k.isNodeOn(end,root.right)))
       {   
           root = k.checkLeft(start, end, root);    
           root = k.checkRight(start, end, root);
       }
       
       System.out.println(root.val);
       if(k.isNodeOn(start,root.left) && k.isNodeOn(end,root.right)){
               
           k.printRoottoNode(start,root.left);
           k.printRoottoNode(end,root.right);
       } else  {
           k.printRoottoNode(start,root.right);
           k.printRoottoNode(end,root.left);
       }
    }
    
    public void printRoottoNode(Node n , Node root){
        System.out.println(root.val+" > ");
         if(root!=null){
            if(root.val == n.val){
                
            } else {
                if(isNodeOn(n,root.left)){
                    printRoottoNode(n,root.left);
                } else {
                    printRoottoNode(n,root.right);
                }
            }
         }
        
    }
    
    public Node checkLeft(Node start, Node end, Node root){
        while(isNodeOn(start,root.left) && isNodeOn(end,root.left)){
           root=root.left;
       }
        return root;
    }
    public Node checkRight(Node start, Node end, Node root){
        while(isNodeOn(start,root.right) && isNodeOn(end,root.right)){
           root=root.right;
       }
        return root;
    }
    
    public boolean isNodeOn(Node n, Node root){
        if(root!=null){
            if(root.val == n.val){
                return true;
            } else {
                return (isNodeOn(n,root.left) || isNodeOn(n, root.right));
            }
        }
        return false;
    }
    
    public Node createNode(char c){
        Node n =  new Node();
        n.val = c;
        return n;
    }
  
        public  Node makeSampleTreeA() {
        Node a = new Node();
        Node b = new Node();
        Node c = new Node();
        Node d = new Node();
        Node e = new Node();
        Node f = new Node();
        Node g = new Node();
        Node h = new Node();
        Node i = new Node();
        a.val = 'a';
        b.val = 'b';
        c.val = 'c';
        d.val = 'd';
        e.val = 'e';
        f.val = 'f';
        g.val = 'g';
        h.val = 'h';
        i.val = 'i';
        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;
        d.left = f;
        e.right = g;
        f.left = h;
        f.right = i;
        return a;
    }

   public class Node {
        Node left;
        Node right;
        char val;
    }
}
