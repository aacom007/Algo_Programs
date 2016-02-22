/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package substring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author akshay anand
 */
public class maxones {
    
    public class value{
        Integer sum =0,i=0,j=0;
    }
    
    public void max(){
        ArrayList<ArrayList<Integer>> startend = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> x = new ArrayList<Integer>();
        x.addAll(Arrays.asList(0,1,1,0,1,0,0,1));
        
        int m =     1;
        int mint = m;
        value maxi =     new value();
        value cur_max = new value();
        cur_max.i =0;
        
        for(int i=0; i<x.size(); i++){
       
             System.out.println(x.get(i));
       
            if(x.get(i)==0){
                if( m > 0 ){
                    cur_max.sum = cur_max.sum + 1;
                    m--;
                    cur_max.j = i;
                }
                if ( m == 0){
                    cur_max.sum = 1;
                    cur_max.i = i;
                    cur_max.j = i;
                    m = mint-1;
                }
            } else {
                cur_max.sum = cur_max.sum+1;
                cur_max.j = i;
            }
              
            //System.out.println("cur_max "+ cur_max.sum + "  max.sum "+ maxi.sum+"");
            if( maxi.sum < cur_max.sum ){
                maxi = cur_max;
                //System.out.println("MAX"+ maxi.sum + "Length "+ (maxi.j   + " " + maxi.i));
            }
        }
        
        
        System.out.println("MAX Length found was"+ maxi.sum + "Starts at  "+ (maxi.j + " Ends at"+maxi.i));
        
    }
    
}
