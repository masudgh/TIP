package com.llstq;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*

Reverse a Linked List in groups of given size
Given a linked list, write a function to reverse every k nodes (where k is an input to the function).
Example:
Inputs: 1->2->3->4->5->6->7->8->NULL and k = 3
Output: 3->2->1->6->5->4->8->7->NULL.
Inputs: 1->2->3->4->5->6->7->8->NULL and k = 5
Output: 5->4->3->2->1->8->7->6->NULL.

 */
public class ReverseKthList {

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private static Node reverseList(Node node, int k){
        if(node == null || k==0) return null;
        if(node.next == null || k ==1) return node;

        Stack<Node> kStack = new Stack<>();

        Node head = null;
        Node curr = node;
        Node newCurr = null;
        Node newPrev = null;


        int i =1;
        int cycle =0;
        while(curr != null){

            if(i<=k){
                kStack.push(curr);
            }
            if( i ==k){
                i=1;
                cycle++;
            }

            curr = curr.next;
            i++;

            if(kStack.size() ==k){
                if(cycle ==1) {
                    head = kStack.pop();
                    newCurr = head;
                    newPrev = head;
                }

                while(!kStack.isEmpty()){
                    newCurr = kStack.pop();
                    newPrev.next = newCurr;
                    newPrev = newCurr;
                    newCurr.next = null;
                }
            }
        }


        while(!kStack.isEmpty()){
            newCurr = kStack.pop();
            newPrev.next = newCurr;
            newPrev = newCurr;
            newCurr.next = null;
        }


        return head;
    }

    public static void main( String [] args){
        int [][] arr = {
                { 1,2,3,4,5,6,7,8},
                {1,2,3,4,5,6,7,8},
                {1,2,3,4,7,0},
                {4}
        };
        Node head;
        Node modHead;

        head= createList( arr[0] );
        printList("Original list :", head);
        modHead = reverseList(head,3);
        printList("Reverse every 3 position of the list :", modHead);

        head= createList( arr[0] );
        printList("Original list :", head);
        modHead = reverseList(head,5);
        printList("Reverse every 5 position of the list :", modHead);
    }

    //Utility Method
    private static Node createList(int [] arr){
        if(arr == null) return null;

        Node head = new Node(arr[0]);
        Node current = head;


        for (int i=1; i< arr.length; i++){
            Node tmp = current;
            current = new Node(arr[i]);
            tmp.next = current;
        }
        return head;
    }


    //Utility Method
    private static void printList(String str, Node head){
        System.out.println(str);

        while (head !=null){
            System.out.print(head.value + "->");
            head = head.next;
        }
        System.out.println();
    }
}
