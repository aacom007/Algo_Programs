/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author akshay anand
 * This problem is to solve finding names on a phone book contact
 * this is the fastest way to search and store names in a phone book.
 * Only drawback is if you want to store same names with phone number then it won't work. 
 * You need to give a unique name to each name.
 */


/*Contact List class*/
public  class ContactList {
    
    private int samename        = 0;
    String name                 = "";
    static ContactList [] child = new ContactList[26];
          
    public  void add( String s, ContactList c, int index )
    {
        
        samename++;
        
        if(index > 0)
        {
           // name += ""+s.charAt(index-1);
           //System.out.println(s.charAt(index-1));
        }
        
        if(index == s.length())
        {
            return;
        }
        
        if(c.child[s.charAt(index)-'a'] ==null)
        {
            c.child[s.charAt(index)-'a'] = new ContactList();
        }
        
        add(s,c.child[s.charAt(index)-'a'],index+1);
        
    }
    
    public static ContactList findChar(char c){
        return child[(int)(c-'a')];
    }
    
    public static boolean find(String s){
        int i            = 0;
        ContactList node = null;

        while( i<s.length() ) {
            
            node     = findChar(s.charAt(i));
            
           // System.out.println("Size :"+node.name);
           
            if( node == null ){
            
                return false;
            
            }
            
            i++;
       
        }
        
        return true;
    }
    
}
