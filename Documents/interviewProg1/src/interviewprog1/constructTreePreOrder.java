/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interviewprog1;

/**
 *
 * @author akshay anand
 */
public class constructTreePreOrder {
    
    public  void constructTreePreOrder1(String  str){
        System.out.print("inside  constructTreePreOrder1");
        int []test ={10,5,2,6,11};
        
      node root = constructTree(test);
      printTree(root);
    }
    public static void printTree(node root)
    {
      if(root!=null)
       {
           
            System.out.println( " - "+root.val);
           if(root.left!=null)
          printTree(root.left);
          
          if(root.right!=null)
          printTree(root.right); 
          
         
       }
    }
    
    
    public static node constructTree(int[] nodeVal)
    {
     int length = nodeVal.length;
     if(length==0)
     {
      return null;
     }
     if(length==1)
     {
      node x = new node();
      x.val= nodeVal[0];
      x.left=null;
      x.right=null;
       return x;
     }
     else
     {
      int j=1;
      while(nodeVal[0]>nodeVal[j])
      {
       j++;
      }
      int []leftSubTree = new int [j-1];
      for(int k=1; k<j;k++)
      {
       leftSubTree[k-1] = nodeVal[k];
      }
      int p=0;
      
      int []rightSubTree = new int [length-j];
      
      for(int k=j;k<nodeVal.length;k++)
      {
      rightSubTree[p]=nodeVal[k];
      }
      node newNode = new node();
      newNode.val= nodeVal[0];
      newNode.left = constructTree(leftSubTree);
      newNode.right = constructTree(rightSubTree);
      return newNode;
     }
    }        
}

