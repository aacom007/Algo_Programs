/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author akshay anand
 */
public class Main {
    public static void main(String[] args) {
 
       RadixSort rs = new RadixSort();
       rs.pad();
       for(int i =0;i<rs.findMax().length();i++){
            rs.sortIndex(i);
       }
       rs.print();
       //System.out.println(rs.findMax());
      }
}

