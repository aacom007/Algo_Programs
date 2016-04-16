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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int a = 4;
        int n = -2;
        power x = new power();
        
        System.out.println( "Power of 4 to 3 is: "+ (double)x.callPower(a, n) );
        
    }
    
}
