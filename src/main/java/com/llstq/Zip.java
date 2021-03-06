package com.llstq;

import com.homework.Trees.AllPath;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
Zip a linked list from it two ends.

e.g.
Input: 1->2->3->4->5->6
Output: 1->6->2->5->3->4
Suggested time: 30 minutes
 */
public class Zip {

    static class Node {
        Node next;
        int value;
        Node( int value) {
            this.next = null;
            this.value = value;
        }

    }

    //ZIP method- BRUTFORCE
    private static Node makeZip(Node list){
        if(list == null) return null;

        Node head =list;

        int length =0;

        //Find the length of the list
        while(list.next != null){
            length++;
            list = list.next;
        }
        length++;



        int half =0;
        if( length%2 ==0) half = length/2;
        else half = length/2+1;

        list = head;
        //Set a pointer at  Mid point
        for(int i =0 ; i<half; i++){
            list = list.next;
        }
        Node middle = list;

        Stack<Node> stack = new Stack<>();
        //Reverse the second half of the list
        for(int i=0; i< (length - half ); i++){
            stack.push(list);
            list = list.next;
        }

        //Mix the list now
        Node tmp = head;
        list = head;
        for(int i=0; i< half; i++) {
            list = tmp.next;
            Node second = stack.pop();
            tmp.next = second;
            tmp = list;
            if(i == half-1)
                second.next = null;
            else
                second.next = list;
        }

        return head;
    }


    //ZIP method- Efficient
    private static Node makeZipEff(Node node){
        if(node == null) return null;

        Node head =node;
        Node mid = node;
        Node tail = node;

        //Slow fast approach to detect tail and middle
        while(mid.next!=null){
            if(tail.next.next !=null)
                tail = tail.next.next;
            else{
                tail = tail.next;
                break;
            }
            mid = mid.next;
        }
        mid = mid.next;

        Node curr = mid;
        Node prev =mid;

        //Reverse second half (mid to tail)
        while(curr !=null){
            Node tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr =tmp;
        }
        tail = prev;
        mid.next = null;


        //Merge two list
        curr =head;
        Node curr2=tail;
        while(curr2.next!=null){
            Node tmp = curr;
            Node tmp2 = curr2;
            curr2 = curr2.next;
            curr = curr.next;
            tmp.next= tmp2;
            tmp2.next =curr;
        }



        return head;

    }
    //main
    public static void main(String [] args){
        int [] arr = {1,2,3,4,5,6};
        Node list = buildList(arr);
        printList("Original list", list);
        Node zip = makeZipEff(list);
        printList("Zip list", zip);


    }

    // LIST BUILD Utility Method
    private static Node buildList(int [] arr){
        if(arr == null) return null;
        if(arr.length == 1) return new Node(arr[0]);

        Node curr = null;
        Node prev = new Node(arr[0]);
        Node head = prev;
        for(int i =1; i< arr.length; i++){
            curr = new Node(arr[i]);
            prev.next = curr;
            prev = curr;
        }
        return head;
    }
    // PRINT Utility Method
    private static void printList(String str, Node list){
        System.out.print(str+ " : ");
        while(list.next != null){
            System.out.print( list.value+" -> ");
            list = list.next;
        }
        System.out.print( list.value);
        System.out.println();

    }
}
