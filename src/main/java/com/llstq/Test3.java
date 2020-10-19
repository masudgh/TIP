package com.llstq;

import java.io.IOException;

public class Test3 {

    public static class Node {
        int val;
        Node next;

        public Node (int val){
            this.val = val;
            this.next = null;
        }

    }

    //MAIN
    public static void main(String[] args) throws IOException {
        Node num1List = createList("1");
        Node num2List = createList("2,3");
        printList("Number 1" , num1List);
        printList("Number 2", num2List);

    }

    //Utility Method
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
        while(list != null){
            System.out.print( list.val+" -> ");
            list = list.next;
        }
        System.out.print( "NULL");
        System.out.println();

    }
}
