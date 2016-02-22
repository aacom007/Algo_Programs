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
import java.io.*;
import java.util.*;
public class rotate {
public static void sol(String args[] ) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    
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
    int i=0;
    for( i=0;i<n/2;i++){
        int start = i;
        int end = n-1-i;
       int temp = arr[start][end];
       int j=0;
       for( j= start; j<end;){
           //System.out.print(arr[i][j]);
         
           arr[i][j++]=arr[i][j];
          
       } 
        arr[i][end] = arr[start][end];
        int k=0;
        for( k= start;k<end;){
            //System.out.print(arr[k][end]);
             
            arr[k++][end]=arr[k][end];
             
        }
        // arr[start][end] = arr[end][end];
        
        for( k=end;k>start;){
            //System.out.print(arr[end][k]);
            
            arr[end][k--]=arr[end][k];
           
        }
       arr[end][end]  = arr[end][start];
        for( k= end;k >start;){
            //System.out.print(arr[k][start]);
           
            arr[k--][start]=arr[k][start];
            
        }
         arr[end][start] = temp;
    }

   for( i =0;i<n;i++){
        for(int j =0;j<n;j++){
            System.out.print(arr[i][j]+" ");
        }
         System.out.println("");
    }
}
}