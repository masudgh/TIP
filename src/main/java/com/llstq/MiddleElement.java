package com.llstq;

/*
Find the middle element of a singly linked list. Constraint: Do it in one pass over the list. If it is
even number of elements, then output the 2nd of the middle two elements.
e.g.
1. (standard positive case) For input: 1->2->3->nil, Output should be: 2
2. (positive case with longer list, odd # of nodes). For input: 1->11->45->12->67->89-
>91->nil, Output should be 12
3. (positive case with longer list, even # of nodes). For input: 1->11->45->12->67-
>89->nil, Output should be 12 (2nd of the middle two)
4. For input: nil, output should be nil

 */
public class MiddleElement {

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            next = null;
        }
    }


    private static Node findMiddleNode(Node head){

        if(head == null) return null;

        Node curr = head;
        Node speedyNode = curr;

        while (speedyNode != null && speedyNode.next != null){
            curr = curr.next;
            speedyNode = speedyNode.next.next;
        }

        return  curr;
    }


    public static void main( String [] args){
        Node middle;
        int [] arr1 =  { 1,2,3};
        Node head = createList( arr1 );
        printList(head);

        middle =  findMiddleNode( head);
        System.out.println(middle.value);

        int [] arr2 =  { 1,11,45,12,67,89,91};
        head = createList( arr2 );
        printList(head);

        middle =  findMiddleNode( head);
        System.out.println(middle.value);

        int [] arr3 =  { 1,11,45,12,67,89};
        head = createList( arr3 );
        printList(head);

        middle =  findMiddleNode( head);
        System.out.println(middle.value);
    }

    //Utility Method
    private static Node createList( int [] arr){
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
    private static void printList(Node head){

        while (head !=null){
            System.out.print(head.value + "->");
            head = head.next;
        }
        System.out.println();

    }
}
