
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * given an array find number of occurances of all possible subset sum combinations
 * @author anupam
 */
public class FindNumberOfSumsOfSet {
    
    private ArrayList<ArrayList<Integer>> makeCombinations(int[] a) {
        long pow =(long) Math.pow(2.00, (double) a.length);
        ArrayList<ArrayList<Integer>> combinations = new ArrayList<>();
       for(int i=0;i<pow;i++) {
           String binNum = pad(Long.toBinaryString(i),a.length);
           char[] binChars = binNum.toCharArray();
           ArrayList<Integer> combination = new ArrayList<>();
           for(int j=0;j<binChars.length;j++) {
               if(binChars[j]=='1') {
                   combination.add(a[j]);
               }
           }
           printlist(combination);
           combinations.add(combination);
       }
       return combinations;
    }
    
    private static void printlist(ArrayList<Integer> a) {
        for(int i : a) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
    
    public Map<Integer, Integer> getSumsOfSubSet(int[] a) {
        ArrayList<ArrayList<Integer>> combos = makeCombinations(a);
        Map<Integer, Integer> sumCounts = new HashMap<>();
        for(ArrayList<Integer> x : combos) {
            int s=0;
            for(int i : x) {
                s += i;
            }
            if(sumCounts.containsKey(s)) {
                int c = sumCounts.get(s);
                c++;
                sumCounts.put(s, c);
            }
            else {
                sumCounts.put(s, 1);
            }
        }
        return sumCounts;
        
    }
    
    private static String pad(String binNum,int size) {
        StringBuilder output = new StringBuilder();
       for(int i=0;i<size-binNum.length();i++) {
           output.append("0");
       }
       output.append(binNum); 
       return output.toString();
    }
    
    public static void main(String[] a) {
        int[] ip = {1,3,4,5,2,7,6,9,11,8};
        FindNumberOfSumsOfSet f = new FindNumberOfSumsOfSet();
        System.out.println(f.getSumsOfSubSet(ip));
    }    
}
