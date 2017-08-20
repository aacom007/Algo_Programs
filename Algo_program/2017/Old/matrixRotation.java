/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algo_program;

/**
 *
 * @author akshay anand
 */
public class matrixRotation {
    
    public int [][] rotate(int mat[][]){
        
        int len = mat.length-1;
        int TL =0;
        int BR = len;
        
        while(TL<BR){

            for(int i =TL; i<=BR-1;i++){

                int temp = mat[TL][i];

                mat[TL][i] = mat[len-i][TL];

                mat[len-i][TL] = mat[BR][len-i];

                mat[BR][len-i] = mat[i][BR];

                mat[i][BR] = temp;

            }

            TL++;
            BR--;
        }
        
        return mat;
    }
}
