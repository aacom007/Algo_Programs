@@ -1,53 +0,0 @@
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package anagrams;
import java.util.*;
import java.lang.*;
/**
 *
 * @author akshay anand
 */
public class Anagrams {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String anagram = "aaabccddddf";
        
        char [] str = anagram.toCharArray();
        
        HashMap<Character, Integer> mapping  = new HashMap<Character, Integer>();
        HashMap<Integer, Character> index = new HashMap< Integer, Character>();
        //2Log(n) space
        int j =0;
        //O(n)
        for(int i=0;i<anagram.length();i++){
            if( mapping.containsKey(str[i]))
            {
                int val = mapping.get(str[i]);
                mapping.put(str[i], val+1);
            } 
            else
            {
                mapping.put(str[i], 1);
                index.put(j++, str[i]);
            }
        }
        
        for(int i=0; i< index.size();i++ ){
            char key = (char)index.get(i);
            int val = mapping.get(key);
            System.out.print(key+""+val);
        }
    }
    
}