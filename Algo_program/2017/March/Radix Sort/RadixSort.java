/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @Dated : 03/15/2017
 * @author akshay anand
 */
public class RadixSort {
 
    String [] arr = {"99","994","657","881", "27","34","29", "98","1", "1002"};
    String [] fin = new String[10];
    
    //remove trailing zeros
    public void removeZeros(){
        
    }
    
    public void pad(){
        
        String max = findMax();
        
        int len = max.length();
        
        for(int i =0;i<arr.length;i++){
            if(arr[i].length()<len){
                int padVals = len- arr[i].length();
                
                for(int j=0;j<padVals;j++){
                    arr[i] ="0"+arr[i];
                }
            }
        }
    }
    
    public void sortIndex(int i){
        int m =0;
        int maxlen = findMax().length()-1;
        
        //System.out.print(maxlen+"       ------");
        for(int j=0;j<=9;j++){
            for(int k =0;k<arr.length;k++){
                //System.out.println("CHAR - "+arr[k].charAt(i));
                if(Integer.parseInt(""+arr[k].charAt(maxlen-i)) == j){
                   fin[m++] = arr[k];
                   //System.out.println("FINAL -"+fin[m-1]);
                }
            }
        }
       
        arr= fin.clone();
        
    }
    
    public String findMax(){
        
        long l = Integer.parseInt(arr[0]);
        
        int stringlen = arr[0].length();
        
        for(int i=1;i<arr.length;i++){
            if(arr[i].length()>=stringlen){
                long val = Integer.parseInt(arr[i]);
                
                if(val>l){
                    l=val;
                }
            }
        }
        
        return String.valueOf(l);
    } 
    
    public void print(){
        for(int i=0;i<arr.length;i++){
            
            if(i!=0)
            {
                System.out.print(", ");
            }
            
            System.out.print(arr[i]);
        }
    }
    
    public void runAlgo(){
        // pad
        
        // sort
        
        // print
        
    }
}
