/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package substring;
import java.util.*;

/**
 *
 * @author akshay anand
 */
public class New1 {
    
    
    static TreeMap<String,List<String>> map = new TreeMap<String,List<String>>();
    static Set<String> key;
    static void addSet(String k, String v) {
        List <String> arr = new ArrayList<String>();

        if(map.containsKey(k)) { 
            arr = map.get(k);
        } 
        arr.add(v);
        map.put(k, arr);
    }
   
    static void printSet() {
         //System.out.println("map" + map);
         
        key = map.navigableKeySet();
        while(key.size()>0)
        {
            printFun(key.iterator().next(), 0);
        }
    }
    
    static void printFun(String val, int  space){
          System.out.print(val);
                System.out.println();
           
        if(key.contains(val))
        { 
            List<String> v = map.get(val);
            space++;
            for(int i =0;i<v.size();i++){
                for(int j=0;j<space;j++){
                    System.out.print(" ");
                }
                printFun(v.get(i), space);
            }
            key.remove(val);
            space--;
        }
    }

   
    
    static void remove(Set x){
        //map.remove(x);
        //printSet();
    }
    
    static boolean contains(Object x){
/*
        for(Object o : s){
            System.out.println("pppp  "+ o);
            if(o instanceof HashSet){
                System.out.println("VALUE"+ o +" actual "+ x);
                Object obj = (Object)o;
                if(obj.contains(x)){
                   System.out.println("TRUE");
                   return true;
                }
               
            }
            if(s.contains(x)){
                System.out.println("TRUE");
                return true;
            } 
            
        }
        System.out.println("FALSE"); */
        return false;
    }
    
    ///////////////////////////////////
    static void setFunc(){ 
        Set s = new HashSet<Character>();
        String input = " aecd";
        String input2 = "abcd";
        
        String input3 = new StringBuilder(input2).reverse().toString();
        String input4 = input.concat(input3);
        int length = input4.length(); 
        System.out.println(input4);
        int flag =0;
        for(int i=1,j=length-1;j>i-1; i++,j--){
            
            if(input4.charAt(i)!=input4.charAt(j)){ 
                System.out.println(input4.charAt(i)+" doesnt match with "+input4.charAt(j));
                if(input4.charAt(i+1)!=input4.charAt(j))
                { System.out.println(input4.charAt(i+1)+" doesnt match with "+input4.charAt(j));
                    flag = 1;
                    continue; 
                }
                else if( input4.charAt(i)!=input4.charAt(j-1) )
                {
                  System.out.println(input4.charAt(i)+" doesnt match with "+input4.charAt(j-1));
                    flag=1;
                   break; 
                }
                else if(input4.charAt(i+1)!=input4.charAt(j-1) && i+1 <= j-1){
                  System.out.println(input4.charAt(i+1)+" doesnt match with xxx "+input4.charAt(j-1));
                    flag=1;
                   break; 
                }
            }
            else{
            continue;
            }
        }
        if(flag==0){
            System.out.println("Strings differ by one place");
        } else {
            System.out.println("Strings does not match");
        }
    }
}
