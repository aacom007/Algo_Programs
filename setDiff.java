/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package substring;

import java.util.*;


/**
 *
 * @author akshay anand
 */
public class setDiff {
    
    public void test(){
        String s = "ABCDSFa";
        String b = "EEDSSAFGGABCSDa";
        
        Set s1 = new HashSet<Character>();
        Set b1 = new HashSet<Character>();
        int i = 0;
        for( i =0;i< s.length();i++){
            if(!s1.contains(s.charAt(i))){
                s1.add(s.charAt(i));
            }
        }
        
        for(i=0;i< b.length();i++){
            if(!b1.contains(b.charAt(i))){
                b1.add(b.charAt(i));
            }
        }
       
            b1.removeAll(s1);
       
        
        Iterator m = b1.iterator();
        while(m.hasNext()){
            System.out.println(m.next()); 
        }
            
        
    }
    
}
