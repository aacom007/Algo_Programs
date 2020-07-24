/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algo_program;

import java.util.HashMap;

/**
 *
 * @author akshay anand
 */
public class power {
    
    private static HashMap<Integer, Double> map = new HashMap<Integer, Double>();
   
    private static double power(int a, int n){
        
        if( n < 1 ){
            
            return 1;
        
        }else{
         
            if( n == 1 ){
                
                return a;
                
            }else{
                
                if(map.containsKey(n)){
                    
                    return map.get(n);
                    
                }else{
                    
                    double value = power(a,n/2) * power(a, n/2);
                
                    map.put(n, value);
                    
                    return value;
                    
                }
                
            }
            
        }
    }
    
    public static double callPower(int a, int n){
        
        if(n > 0){
        
            if( n % 2 == 0 ){

                return power( a, n );

            } else {

                return power( a, n-1 ) * a;
            }
            
        } else {
        
            n = n * -1;
            
            if( n % 2 == 0 ){

                return 1/power( a, n );

            } else {

                return 1/(power( a, n-1 ) * a);
            }
        
        }
    }
}
