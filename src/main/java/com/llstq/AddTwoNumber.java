package com.llstq;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/*

A number is represented by a linked list, with the head of the linked list being the least
significant digit.
For example 12 is represented as 2->1, and 23 is represented as 3->2
Adding 2->1 and 3->2 should produce 5->3 which is equivalent to (35).
Write a function which adds two linked lists returning the sum in form of a linked list. Try to
use constant memory.

 */
public class AddTwoNumber {

    public static class Node {
        int val;
        Node next;

        public Node (int val){
            this.val = val;
            this.next = null;
        }

    }


    private static Node addNumList( Node num1, Node num2){

        Node sumCurr = null;
        Node sumHead = sumCurr;
        Node sumPrev = sumCurr;

        int digit1 =0;
        int leftOver =0;

        while(num1 != null || num2 !=null){
            if(num1 != null && num2 !=null) {

                digit1 = (num1.val + num2.val + leftOver) % 10;
                leftOver = (num1.val + num2.val + leftOver) / 10;

            }else if (num1 != null && num2 == null){

                digit1 = (num1.val + leftOver) % 10;
                leftOver = (num1.val + leftOver) / 10;


            }else if (num2 != null && num1 == null ){

                digit1 = (num2.val + leftOver) % 10;
                leftOver = (num2.val + leftOver) / 10;

            }

            if(num1 !=null) num1 = num1.next;
            if(num2 !=null) num2 = num2.next;

            sumCurr = new Node(digit1);
            if(sumPrev !=null ) {
                sumPrev.next = sumCurr; // next all node
            }
            else { //First Node
                sumHead = sumCurr;
            }
            sumPrev = sumCurr;

        }
        if(leftOver >0) {
            sumCurr = new Node(leftOver);
            sumPrev.next = sumCurr;
        }

        return sumHead;
    }


    public static void main (String [] args) throws IOException {

        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader buffer = new BufferedReader(reader);
        String num1 = buffer.readLine();
        String num2 = buffer.readLine();
        Node num1List = createList(num1);
        Node num2List = createList(num2);
        printList("Number 1" , num1List);
        printList("Number 2", num2List);

        Node sumHead =  addNumList(num1List, num2List);

        printList("Sum of number 1 & number 2", sumHead);
    }


    private static Node createList(String num){
        Node numberList;
        if(num == null) return null;
        if(num.isEmpty()) return null;


        String [] arr = num.split(",");

        if(arr.length ==1) return new Node (Integer.parseInt(arr[0]));


        Node head = new Node (Integer.parseInt(arr[arr.length-1]));
        Node prev = head;
        for(int i=arr.length-2; i >-1; i--){
            String str = arr[i];
            Node tmp = new Node( Integer.parseInt(str));
            prev.next = tmp;
            prev = tmp;
        }

        return head;
    }

    // PRINT Utility Method
    private static void printList(String str, Node list){
        System.out.print(str+ " : ");
        while(list.next != null){
            System.out.print( list.val+" -> ");
            list = list.next;
        }
        System.out.print( list.val);
        System.out.println();

    }


}
