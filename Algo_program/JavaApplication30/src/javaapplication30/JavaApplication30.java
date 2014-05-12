/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication30;

/**
 *
 * @author akshay anand
 */


public class JavaApplication30 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //adding nodes
        node n = new node(10);
        node temp1 = new node (5);
        node temp4 = new node (11);
        node temp2 ;
        n.left= temp1;
        n.right= temp4;
        node temp3 = new node(2);
        n.left.left = temp3;
        temp2 = new node(6);
        n.left.right = temp2;
        temp2 = new node(7);
        n.left.right.right = temp2;

        // to check ancestor
        System.out.print(" Nearest common Ancestor is : "+ functionAncestor( temp4,temp2, n).val+"\n\n");
        // to print tree;  
        printMe(n);
    }
    
    
    public static void printMe(node x)
    {
        if(x==null)
            return;
        else 
        {
            System.out.print( "  " + x.val + "- \t -" +"\n" );
        if(x.left!=null)
        printMe(x.left);
        if(x.right!=null)
        printMe(x.right);
        
       
        }
    }
    //this function checks if the node n1 is present in the subtree for which root is given 
    public static boolean check(node root, node n1)
    {
        
        if(root==null)
        {
          return false;   
        }
        if(root.val == n1.val)
        {
            return true;
        }
        
        else
        {
         
            if(check(root.left,n1)||check(root.right,n1))
                return true;
 
          else
          
              return false;
        }
        
        
    }
    
    //function to recursively go deep into the tree and reduce to
    // that subtree which has both the nodes. else it return the common ancestor node..
    public static node functionAncestor(node n1, node n2, node root){
        
               if( check(root.left, n1) && check(root.left,n2) )
               {
                   node val1 = functionAncestor(n1,n2,root.left);
                  
                   
                   if(val1==null )
                       return root;
                       
                   else if(val1!=null)
                       return val1;
                   else 
                       return null;
               }
               else  if( check(root.right, n1) && check(root.right,n2) )
               {
                   node val1 = functionAncestor(n1,n2,root.right);
                  
                   
                   if(val1==null )
                       return root;
                       
                   else if(val1!=null)
                       return val1;
                   else 
                       return null;
               }
               else
                   
               return root;
        
    }
    
}
