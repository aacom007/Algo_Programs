import java.io.*;
import java.util.*;
 

// Roman to Int conversion from 1 till 3999 

class Solution {
	
	
	public static void main(String[] args) {
	
		int k = romanToInt("XII(12)");
		k = romanToInt("IX(9)");
		k = romanToInt("DC(600)");
		k = romanToInt("CD(400)");
		k = romanToInt("III(3)");
		k = romanToInt("LVIII(58)");
		k = romanToInt("MMMCMXCIX");
	}
	
    public static int romanToInt(String s) {
        int sum =0;
        if(s.length()>0){
            int x =0;
            for(int i=0;i<s.length();i++){
                 x = ctoNum(s.charAt(i));
                
                if(i+1<s.length())
                { 
                    int nval = ctoNum(s.charAt(i+1));
                    if(x<nval) {
                        sum+=nval-x;
                        i++;
                    }
                    else {
                        sum+=x;
                    }
                } else {  
                	sum+=x;
                	i++;
                }
            }
        }
        System.out.println(s+" = "+sum);
        return sum;
    }
    
    public static int ctoNum(Character c){
        if(c=='V'){
            return 5;
        }

        if(c=='X'){
            return 10;
        }

        if(c=='L'){
            return 50;
        }

        if(c=='C'){
            return 100;
        }

        if(c=='D'){
            return 500;
        }

        if(c=='M'){
            return 1000;
        }

        if(c=='I'){
            return 1;
        }
        return 0;
    
  }
}
 
