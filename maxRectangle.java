/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package substring;

import substring.kaden.kd;

/**
 *
 * @author akshay anand
 */
public class maxRectangle {
    // 4*4 matrix
    public Integer  maxRectangleSum [][]=  new Integer[][]
    {
        {-1,-12,3,4},
        {-1,-1,-1,4},
        {1,9,3,4},
        {1,2,0,4}
    }; 
    
    Integer [] copy = new Integer[4];
    
    Integer maxLeft =0, maxRight =0, maxUp=0, maxDown=0; 

    float maxSum =0, curSum =0;
    public void maxRect(){
        
        for(int k=0;k<4;k++){
                    copy[k]= 0;
                }
        kaden co = new kaden();
        
        for(int i =0;i<4;i++){
            for(int j=0;j<4;j++){
                for(int k=0;k<4;k++){
                    copy[k]+= maxRectangleSum[k][j];
                }
                kd x = co.kadenMaxSum(copy);
            
                curSum = x.sum;
                
                if(maxSum< curSum){
                    maxSum = curSum;
                    maxLeft = i;
                    maxRight = j;
                    maxUp = x.i;
                    maxDown = x.j;
                }
            }
            for(int k=0;k<4;k++){
                    copy[k]= 0;
                }
        }
        
        System.out.println(""+ maxSum + " Max Sum "+
                    maxLeft+ " Max Left " +
                    maxRight+ " MAx right " +
                    maxUp + " AMx Up" +
                    maxDown+" MAx DOwn");
    };
    
}
