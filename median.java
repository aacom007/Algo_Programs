/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package substring;
import java.util.*;
import java.math.*;
/**
 *
 * @author akshay anand
 */
public class median {
    
    public static void med(){
    
        int [] A ={ 1,2,3,4,5,6};
        
        int [] B ={ 7,8,9,10,11,12,13};
    
        // find median
        
       int lenA = A.length;
       int lenB = B.length;
       
      System.out.println( kMedian(A,B,lenA,0,0, lenB) );
    }
   
    public static int kMedian(int[] A, int [] B, int startA, int endA, int startB, int endB){
        
        if(endA== startA){
        
            
        }
        
        int medA = A[(int) Math.floor(Math.abs(endA-startA)/2)];
        int medA1 = A[(int) Math.floor(Math.abs(endA-startA)/2)+1];
        int medB = B[(int) Math.floor(Math.abs(endB-startB)/2)];
        
        int medB1 = B[(int) Math.floor(Math.abs(endB-startB)/2)+1];
         
         if( medA < medB &&  medB < medA1){
            
            return medB;
        }
        
        if(medA < medB){
            return kMedian(A,B, (int)Math.abs(endA-startA)/2, endA, startB, Math.abs(endB-startB)/2 );
        }
       
        if( medB < medA &&  medA < medB1){
            
            return medA;
        }
        
         
        if(medB < medA){
           return kMedian(A,B, (int)Math.abs(endB-startB)/2 , endB,Math.abs(endA-startA)/2 , endA );
        
        }
        return -1;
    }
}
