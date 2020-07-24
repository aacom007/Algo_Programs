
package substring;
import java.util.*;
import java.lang.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author akshay anand
 */
public class subSet {
    
    static TreeMap<Integer, ArrayList<ArrayList<Integer>>> totalSet = new TreeMap<Integer , ArrayList<ArrayList<Integer>>>();
           
    public static void set(Integer m){
        totalSet.put(0, new ArrayList<ArrayList<Integer>>());
        System.out.println(totalSet);
        for(int i=1;i<=m;i++){
            
            ArrayList<ArrayList<Integer>> j = new ArrayList<ArrayList<Integer>>();
            
            j.addAll(totalSet.get(i-1));
            
            
            
            System.out.println(totalSet.get(i-1)+"ouuut");
            ArrayList<Integer> newSubSet = new ArrayList<Integer>(); 
            for(ArrayList<Integer> y : totalSet.get(i-1)){
                
                newSubSet.addAll(y);
                for(Integer mk: y){
                    newSubSet.add(mk);
                    newSubSet.add(i);
                }
            }
            j.add(newSubSet);
            totalSet.put(i, j);
        }
        
        System.out.println(totalSet.get(m));
    }
    
}
