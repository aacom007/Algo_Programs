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
 
        ContactList c = new ContactList();
        String s = "akshay";
        c.add(s, c, 0);
        s= "nancy";
        c.add(s,c,0);
        s= "nana";
        c.add(s,c,0);
        System.out.printf("was gg was found ? "+ c.find("gg"));
         System.out.printf("was nancy found ?  "+ c.find("nancy"));
      }
}
