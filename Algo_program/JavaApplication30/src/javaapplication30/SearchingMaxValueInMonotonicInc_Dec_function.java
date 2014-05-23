/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication30;

/**
 *
 * @author akshay anand
 */
// Here we have a array list which we know is first monotonically 
//increasing and then its decreasing. We need to find the maximum value in the list with best time complexity. 
//This solution is in less than O(n)
public class SearchingMaxValueInMonotonicInc_Dec_function {
   
    public static void main(String[] str)
    {
   int []a ={1,2,3,4,5,7,11,12,3};
        int max=0;
        binarySearch(0, a.length,max,a);
    }
    public static void binarySearch(int start, int end, int max, int[] a)
    {
      int mid = (start+end)/2;
      if(a[mid]>max)
      {
        
          
          
          if(a[mid-1]>a[mid])
          {
           max = a[mid-1];
           end = mid-1;
           
          }
          
          
          else if( a[mid+1]>a[mid] )
          {
              max=a[mid+1];
              end = mid+1;
          }
          
         
          
          binarySearch(start, end, max, a);
           }
      
      
      System.out.print(" s"+ max);
    }
    
}

