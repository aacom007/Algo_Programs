/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algo_program;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author akshay anand
 */
public class continous {
    
    private static HashMap<Character, Boolean> map = new HashMap<Character, Boolean>();
    
    private char curr;
    
    Queue<Character> qu = new LinkedList<Character>();
    
    public void nextValue(char c){
        
        if(!map.containsKey(c)){
            
            map.put(c, Boolean.TRUE);
            
            qu.add(c);
            
        } else {
            
            if(qu.contains(c)){
                
                qu.remove(c);
                
            }
            
        }
        
        System.out.println(qu.peek());
    }
}
