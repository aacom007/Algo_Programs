/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javacoding;

/**
 *
 * @author akshay anand
 */
public class JavaCoding {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
        System.out.println("out :"+ makePalindrome ("addxx"));
    }
/**
 *
 * @author akshay anand
 */
    
    public static  String makePalindrome(String s)
    {
        if(s ==null)
        {
        return "";
        }
        
        if(s.length()==1)
        {
         return s; 
        }
        
        String []sarray1 = s.substring(0, s.length()/2).split("");
        String []sarray2 =  s.substring(s.length()/2,s.length()).split("");
         if(check(sarray1,sarray2))
         {
             return s;
         }
         else
         {
             
             String s11 =s.substring(1,(s.length()));
             String s12 = makePalindrome( s11);
             
             return s.charAt(0)+s12+ s.charAt(0);
         }
    }

    
    public static boolean check(String[] s2, String[] s3)
    {
        if(s2.equals(reverse(s3)))
            return true;
        else
            return false;
    
    }
    public static String reverse(String []s)
    {
         String s1 ="";
         
         for(int i= s.length-1;i>=0 ;i--)
         {
             s1+=s[i];
         }
         return s1;
    }
    
    }
    

