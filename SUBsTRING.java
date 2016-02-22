/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package substring;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

/**
 *
 * @author akshay anand
 */


public class SUBsTRING {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //subSet x  = new subSet();
         //x.set(3);
       
// TODO code application logic here
        
        // max sum in rectangle
      //  maxRectangle x = new maxRectangle();
        //x.maxRect();
// kaden max sub array sum 
   // Integer []x = { -1, 0, 3, 5, 6};
    //kaden p = new kaden();
    //p.kadenMaxSum(x);
  //Code for sub island 
       //subIsland x = new subIsland();
       //x.count();
        
        // Code for printing hirarchy
maxones x = new maxones() ;
x.max();
      /*  New1 x = new New1();
        x.addSet("animal", "bird");
        x.addSet("animal", "mammal");
        x.addSet("mammal", "seal");
        x.addSet("animal", "cheeta");
        x.addSet("mammal", "seal2");
        x.addSet("bird", "parrot");
        x.addSet("parrot", "cage");
        x.printSet();
     */
        
        //test();
        
        /*
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [][] arr = new int[n][];

        for(int i =0;i<n;i++)
           arr[i] = new int[n];

        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                arr[i][j] = scan.nextInt();
            }
        }

        arr = rotateMatrixBy90Degree(arr, n);
        
         for(int i =0;i<n;i++){
             System.out.println("");
            for(int j =0;j<n;j++){
                System.out.print(arr[i][j] + " ");
            }
        }*/
}

    public static void test() {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        try{
            BufferedReader buffer=new BufferedReader(new FileReader("test.txt"));
            String[] input1 = buffer.readLine().split(" "); 
            String[] input2 = buffer.readLine().split(" ");
            int n = Integer.parseInt(input1[0]);
            int k = Integer.parseInt(input1[1]);
            PriorityQueue<Integer> arr = new PriorityQueue<Integer>();
            int b =0;
            for(int i = 0;i < input2.length;i++) {
                arr.add(Integer.parseInt(input2[i]));
            }
            int val =0;
            int operations =0;
           
            while(val<k){
                val=sweetness(arr);
                arr.add(val);
                System.out.println(val +" " +arr.size()+ " ");
                operations++;
                if(arr.size()<2){
                   break;
                }
            }
            if(val>k)
            {
                System.out.println(operations);
            } else {
                System.out.println("-1");
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static Integer sweetness(PriorityQueue<Integer> x){
        Integer a = x.poll();
        Integer b = x.poll();
        
        //System.out.print(a +" "+ b+ "  --");
        
        return a+ 2* b;
    }
} 
    
    
    
    