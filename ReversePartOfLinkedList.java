/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Stack;
/**
 * Program to reverse part of the linked list. the part size is specified as input.
 * linked listed is singly linked list
 * eg: if the linked list is 1 2 3 4 5 6 and part size is 3 then the output should be 
 * 3 2 1 6 5 4
 * @author anupam
 */
public class ReversePartOfLinkedList {
    public LinkedListNode reverseLinkedList(LinkedListNode root, int num) {
        int ntemp = num;
        LinkedListNode temp = root;
        LinkedListNode output = new LinkedListNode();
        LinkedListNode otemp = output;
        Stack<Integer> s = new Stack<>();
        while(true) {
            while(ntemp > 0) {
                ntemp--;
                s.push(temp.value);
                if(temp.next != null)
                    temp = temp.next;
                else 
                    break;
            }        
            while(true) {
                otemp.value = s.pop();
                if(!s.isEmpty()) {
                    otemp.next = new LinkedListNode();
                    otemp = otemp.next;
                }
                else {                    
                    break;
                }
            }
            if(temp.next != null) {
                ntemp = num;
                otemp.next = new LinkedListNode();
                otemp = otemp.next;
            } 
            else 
                break;
        }
        return output;
    }
    void printLinkedList(LinkedListNode root) {
        if(root.next != null) {
            System.out.print(root.value + " ");
            printLinkedList(root.next);
        }
        else {
            System.out.print(root.value + " ");
        }
    }
    
    public static void main(String[] args) {
        ReversePartOfLinkedList r = new ReversePartOfLinkedList();
        r.printLinkedList(sampleLinkedList());
        LinkedListNode s = r.reverseLinkedList(sampleLinkedList(), 4);
        System.out.println();
        r.printLinkedList(s);
    }
    
    public static LinkedListNode sampleLinkedList() {
        LinkedListNode l = new LinkedListNode();
        l.value = 3;
        LinkedListNode l2 = new LinkedListNode();
        l2.value = 4;
        LinkedListNode l3 = new LinkedListNode();
        l3.value = 5;
        LinkedListNode l4 = new LinkedListNode();
        l4.value = 6;
        LinkedListNode l5 = new LinkedListNode();
        l5.value = 7;
        LinkedListNode l6 = new LinkedListNode();
        l6.value = 8;
        l.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        return l;
    }
}
 class LinkedListNode {
     LinkedListNode next;
     int value;
 }