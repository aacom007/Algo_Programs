/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package substring;

/**
 *
 * @author akshay anand
 */
public class tree {
    
    Integer value = null;
    tree left;
    tree right;
    
    tree(int val){
        this.value = val;
        this.left =  null;
        this.right = null;
    }

    public static void add(tree t, int val){

        if( t.value > val ){
            if(t.left!=null)
                add(t.left, val);
            else{
                tree newNode = new tree(val);
                t.left=newNode;
            }
        } else {
            if(t.right!=null)
                add(t.right, val);
            else{
                tree newNode = new tree(val);
                t.right=newNode;
            }
        } 
    }
    
    public static void search( tree root, int val){
        
    }
}
