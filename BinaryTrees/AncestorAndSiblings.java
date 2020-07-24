/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import common.BinaryTreeNode;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Program to find the kth sibling and the kth ancestor of a given node.
 * @author anupam
 */
public class AncestorAndSiblings { 
    
    public BinaryTreeNode getSibling(BinaryTreeNode rootNode, int value,int k) {
        Queue<BinaryTreeNode> t = new ArrayDeque<>();
        Stack<BinaryTreeNode> bfsStack = new Stack<>();
        BinaryTreeNode temp = rootNode;
        if(temp != null) {
            t.add(temp.left);
            t.add(temp.right);
           while(!t.isEmpty()) {
                temp = t.peek();
                bfsStack.push(temp);
                t.add(temp.left);
                t.add(temp.right);
                if(temp.value == value) {
                    break;
                }                
            }
            while(k >=0) {
                if(bfsStack.isEmpty()) {
                    return null;
                }
                else
                    bfsStack.pop();
                k--;                
            }
            return bfsStack.peek();
        }
        else {            
             return null;
        }
    }
    private BinaryTreeNode ancestor;
    public BinaryTreeNode getAncestor(BinaryTreeNode rootNode, int value, int k) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        getPaths(rootNode,stack,k,value);
        return ancestor;
    }
    
    private void getPaths(BinaryTreeNode node, Stack<BinaryTreeNode> stack,int k, int value) {
        if(node == null) {
            return;
        }     
        stack.push(node);
        // its a leaf node
        if(node.left == null && node.right == null) {
            while(!stack.isEmpty()) {
                BinaryTreeNode temp = stack.pop();
                if(temp.value == value) {
                    while(k >=0) {
                        k--;
                        if(!stack.isEmpty()) {
                            stack.pop();
                        }
                    }
                    ancestor = stack.pop();
                    System.out.println(ancestor.value + " is the kth ancestor ");
                    return;
                }
            }
        }
        else {
            getPaths(node.left,stack,k,value);
            getPaths(node.right, stack,k,value);
        }
    } 
    
    public static void main(String[] args) {
        AncestorAndSiblings bfsTree = new AncestorAndSiblings();
        System.out.println("1th sibling 14= "+ bfsTree.getSibling(sampleTree(), 14, 1));
         System.out.println("1th ancestor 14= "+ bfsTree.getAncestor(sampleTree(), 14, 1));        
    }
    
    
    public static BinaryTreeNode sampleTree() { 
        BinaryTreeNode root = new BinaryTreeNode();
        root.value = 10;
        BinaryTreeNode temp = new BinaryTreeNode();
        temp.value = 12;
        root.left = temp;
        BinaryTreeNode temp2 = new BinaryTreeNode();
        temp2.value = 11;
        root.right = temp2;
        BinaryTreeNode temp3 = new BinaryTreeNode();
        BinaryTreeNode temp4 = new BinaryTreeNode();
        temp3.value = 13;
        temp4.value = 14;
        temp2.left = temp3;
        temp2.right = temp4;
        BinaryTreeNode temp5 = new BinaryTreeNode();
        BinaryTreeNode temp6 = new BinaryTreeNode();
        temp5.value = 15;
        temp6.value = 16;
        temp4.left = temp5;
        temp4.right = temp6;
        return root;
    }
}

