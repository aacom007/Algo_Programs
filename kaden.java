/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package substring;

import java.sql.Struct;

/**
 *
 * @author akshay anand
 */


public class kaden {

    public class kd {
        float sum = 0.0f;
        Integer i = 0;
        Integer j = 0;
    };
    
// finds maximum sum of array's sub array in O(n) time. 
    public kd kadenMaxSum(Integer [] arr){
     
        kd max = new kd();
        kd max_cur = new kd();
        kd result = new kd();
        
        for( int i =0; i<arr.length; i++ ){
            
            if(max_cur.sum < 0){
                max_cur.sum = arr[i];
                max_cur.i = i;
                max_cur.j = i;
            } else {
                max_cur.sum += arr[i];
                max_cur.j = i;
            }
                
            if(max_cur.sum>max.sum){
                max= max_cur;
            }
            System.out.println("Current max_cur "+ max_cur.sum + "  max_cur.i "+ max_cur.i + " max_cur.j "+ max_cur.j);
            System.out.println("Current max "+ max.sum + "  max.i "+ max.i + " max.j "+ max.j);
        }
        System.out.println("Max "+ max.sum + "  max.i "+ max.i + " max.j "+ max.j);
        result = max;
        
        return result;
    };
}
