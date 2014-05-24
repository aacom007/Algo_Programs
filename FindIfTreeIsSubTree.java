/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * program to find if treeB is a subtree of treeA or not
 * @author anupam
 */
public class FindIfTreeIsSubTree {
    boolean check(Node treeA, Node treeB) {
        if(treeA == null || treeB == null) {
            return false;
        }
        if(treeA.val == treeB.val) {
            if(treeB.left == null && treeB.right == null) {
                if(treeA.left == null && treeA.right == null) {
                    return true;
                }
                else {
                    return false;
                }
            }
            else if(treeB.left != null && treeB.right == null) {
                if(treeA.left != null && treeA.right == null) 
                    return (check(treeA.left,treeB.left));
                else
                    return false;
            }
            else if(treeB.left == null && treeB.right != null) {
                if(treeA.left == null && treeB.right != null)
                    return (check(treeA.right, treeB.right));
                else
                    return false;
            }
            else {
                return (check(treeA.left, treeB.left) && 
                        check(treeA.right, treeB.right));
            }
        }
        else {
            if(treeA.left == null && treeA.right == null) {
                return false;
            }
            else {
                return (check(treeA.left, treeB) ||
                        check(treeA.right, treeB));
            }
        }
    }
    
    public static void main(String[] s) {
        FindIfTreeIsSubTree f = new FindIfTreeIsSubTree();
        System.out.println(f.check(makeSampleTreeA(), makeSampleTreeB()));
    }
    
    public static Node makeSampleTreeA() {
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
    
    public static Node makeSampleTreeB() {
        
        Node e = new Node();
        Node f = new Node();
        Node g = new Node();
        Node h = new Node();
        Node i = new Node();
        e.val = 'e';
        f.val = 'f';
        g.val = 'g';
        h.val = 'h';
        i.val = 'i';
        e.right = g;
        f.left = h;
        f.right = i;
        return e;
    }
}

class Node {
    Node left;
    Node right;
    char val;
}