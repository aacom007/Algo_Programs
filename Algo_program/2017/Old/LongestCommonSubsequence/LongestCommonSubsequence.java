@@ -1,72 +0,0 @@
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author akshay anand
 * Longest Common Subsequence
 */
public class LongestCommonSubsequence {
    
       
    public static int max(int a, int b){
    
        return a>b? a : b;
        
    }

    // Assuming both string length is same 
    // Finding common longest subsequence
    public static void LCS(String a, String b){
   
       int [][]mat = new int[a.length()+1][a.length()+1];
       char [] a1  = a.toCharArray();
       char [] b1  = b.toCharArray();
       
       for(int k = 0; k < a.length()+1; k++){
           mat[0][k] = 0;
           mat[k][0] = 0;
       }

       for(int i =1;i<a1.length+1;i++){
       
           for(int j=1;j<b1.length+1;j++){

               if(a1[i-1]==b1[j-1]){
                   mat[i][j] = mat[i-1][j-1] + 1;
               }
               else{
                  mat[i][j] =  max(mat[i-1][j], mat[i][j-1]);
               }
               
           }
       }
       
       System.out.println();
       
       System.out.println("Longest common subsequent");
       
       System.out.println();
       
       for(int i = a1.length; i > 0 ; i--){
           
           for(int j = a1.length; j > 0; j--){
           
               if( mat[i][j] > mat[i-1][j-1]){
                   
                    System.out.print(a1[i-1] +" ");
                   
                    j--;
                    i--; 
                    
                    if(i<=0){
                        break;
                    }
                }
           }
       }
   }   
}