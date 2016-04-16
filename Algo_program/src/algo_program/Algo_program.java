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
public class Algo_program {
    // continous input 
    
    public static void main(String[] args) {
        // TODO code application logic here
        String str  = "aabcccsssssdfsssseb ";
        
        continous x = new continous();
        char [] input = str.toCharArray();
        
        for(int i =0;i< input.length; i++){
        
            x.nextValue(input[i]);
        }
        
    }
    
    
    /**
     * @param args the command line arguments
     * program start for power a,n
     */
/*    public static void main(String[] args) {
        // TODO code application logic here
        int a = 4;
        int n = -2;
        power x = new power();
        
        System.out.println( "Power of 4 to 3 is: "+ (double)x.callPower(a, n) );
        
    }
*/    
}
