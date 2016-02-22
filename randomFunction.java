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


public class randomFunction {

    public static boolean [] arr = new boolean[10] ;

public void randomFunction(){
    Arrays.fill(arr, false);
}
public static Integer getNum(){
    double r = Math.random();
    double g = 10;
    Integer m; 
    m = (int)(r * g);
    return m;
}
 

public static Integer funct(){
    Boolean flag = false;
    while(!flag)
    {
        int max =0;
        for(int i=0;i<10;i++){
            System.out.println(arr[i]+"--"+i);
            if(arr[i])
                max++;
        }
        
        if(max==10){
         return -1;
        }
        int m = getNum();
        if(arr[m]==false){
            arr[m]= true;
            flag=true;
            return m;
        }
    }
    return 0;
}   
    
}
