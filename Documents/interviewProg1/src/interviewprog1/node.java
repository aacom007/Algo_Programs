/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interviewprog1;
import java.util.HashMap;
/**
 *
 * @author akshay anand
 */



public class node {
private Character value;
private HashMap<Character,node> firstChild;
private node nextSib;
private boolean isEnd;

public node(Character ch){
value = ch;
firstChild = new HashMap<>();
isEnd = false;
}

public HashMap<Character, node> getChild(Character ch)
{
    return firstChild;
}
public boolean isEndTrue()
{
    return isEnd;
}

public void setIsEnd(boolean x){
    isEnd = x;
}

public void insert(String val,node root){
    
}

}
