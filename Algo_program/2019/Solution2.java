import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 Author:	akshayan@usc.edu 
 
  */


class Solution2 {
	
	
	public static void main(String[] args) {
		  
	    largestNumber("135","246");
	    largestNumber("531","642");//654321 
	    largestNumber("3","8127"); //83127
	    largestNumber("1000","8127333333300"); //  81273333333100000
	    largestNumber("12","21"); // 2121
	    largestNumber("12","210");// 21210
	    largestNumber("121","212");// 212121
	} 

  public static void largestNumber(String a, String b){
  
    
    int len1 = a.length();
    int len2 = b.length();
    
    //base one of the string is empty
    if(len1 == 0){
      System.out.println(b);
      return;
    }
    if(len2 == 0){
      System.out.println(a);
      return;
    }
    
    //int maxLen = len1 < len2 ? len2 : len1;
    int x = 0;
    int y = 0;
    StringBuilder sb = new StringBuilder();
    while(x<len1 && y<len2){
      if(a.charAt(x)>b.charAt(y)){
        sb.append(a.charAt(x));
        x++;
      } else if(a.charAt(x)<b.charAt(y)){
        sb.append(b.charAt(y));
        y++;
      } else{
        //x === y
    	long xrem = 0;
    	long yrem = 0;
    	if(x<len1) {
    		xrem = Long.parseLong(a.substring(x));
    	}
    	if(y<len2) {
    		yrem = Long.parseLong(b.substring(y));
    	}
    	if(yrem>xrem) {
    		sb.append(b.charAt(y));
    		y++;
    	} else {
    		sb.append(a.charAt(x));
    		x++;
    	}
      }
    }
    
    if(y < len2){
      sb.append(b.substring(y,len2));
    } 
                
    if(x < len1){
      sb.append(a.substring(x,len1));
    }             
                
    System.out.println(sb.toString());
    return;    
  }
  
  
}


/* 

Given two strings of positive integers, find the largest number you can form by interleaving the digits.

Input: '135', '246'
Output: '246135'

Input: '531', '642'
Output: '654321'

Input: '3', '8127'
Output: '83127'

'135', '246'
 ^         ^
 
 
 246135


 */
