/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interviewprog1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Vector;

/**
 *
 * @author akshay anand
 */
public class InterviewProg1 {

    /**
     * @param args the command line arguments
     */
    static Integer sum=0;
    
    public static void main(String[] args) {
        // TODO code application logic here
   
        
        constructTreePreOrder  x = new constructTreePreOrder();
        System.out.println("sdfsafsd");
        x.constructTreePreOrder1("test");
        /*
        ArrayList<Float> arr = new ArrayList<Float>();
       //Bucket sort
        
        arr.add(0, 0.0442f);
        arr.add(0, 0.1442f);
        arr.add(0, 0.3442f);
        arr.add(0, 0.5442f);
        arr.add(0, 0.6442f);
        arr.add(0, 0.7442f);
        
        arr = BucketSort(arr, arr.size());
     
        

        */
        
    }
    
    public static ArrayList<Float>  BucketSort( ArrayList<Float> test ,Integer size)
    {
        Vector<Float> vec = new Vector<>();
        for(Integer i=0;i<size;i++)
        {
            Integer b= (size)*Math.round(test.get(i)) ;
            vec.insertElementAt(test.get(i), b);
        }
        
       // for (int i=0; i<b ; i++)
            
           // (vec.firstElement(), vec.lastElement()) ;
        
        
        return test;
    }
    
    
    public static Integer MaxSum(ArrayList<Integer> arr, Integer i)
    {
        
      if(i< arr.size()-1)
      {
        Integer nextElement =arr.get(i+1);
        Integer Newsum =sum+nextElement;
        if(Newsum> sum)
        {
            if(Newsum>nextElement)
            {
                sum = Newsum;
                return MaxSum(arr,i+1);
            } 
            else
            {
                sum =nextElement;
                return MaxSum(arr,i+1);
            }
        }      
        else
        {
             return sum;
        }
        
      }
     else
      return sum;

    }
    
}
