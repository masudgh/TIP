package com.llstq;

import java.util.LinkedList;
import java.util.Queue;

/*
In a given singly Linked List of length N, swap kth node from the beginning, with kth node from
the end. We're not swapping just the contents; we're swapping the nodes themselves. 'K' is
understood as based on 1 i.e. (1<= K <=N).
e.g.:
1. Input: 1->2->3->4->7->0, K=2 Output: 1->7->3->4->2->0
2. Input: 1->2->4->7->0, K=3 Output: 1->2->4->7->0
3. Input: 1->2->3->4->7->0, K=5 Output: 1->7->3->4->2->0
4. Input: 4, K=1 Output: K=4

 */
public class SwapKthNode {

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }


    private static Node swapKNodeInList(Node node, int k){
        if(node == null || k==0) return null;
        if(node.next == null || k ==1) return node;

        Queue<Node> kQueue = new LinkedList<>();

        Node head = node;
        Node curr = node;
        Node prev = curr;
        Node prevFirstKth=null;
        Node firstKth = null;
        Node lastKth = null;
        Node prevLastKth = null;

        int i =1;
        while(curr.next != null){

            if(i == k){
                firstKth = curr;
                if(k>1) prevFirstKth = prev;
            }
            kQueue.add(curr);
            if(kQueue.size() == k+1)
                kQueue.poll();

            prev = curr;
            curr = curr.next;
            i++;
        }

        if(kQueue.size() >0) {
            prevLastKth =  kQueue.poll();
            lastKth = kQueue.poll();
        }

        if( firstKth != null && lastKth !=null){
            //Swap the node
            if(prevFirstKth!= null)
                prevFirstKth.next = lastKth;
            else
                lastKth = head;

            if(prevLastKth !=null)
                prevLastKth.next =firstKth;
            else
                head =firstKth;

            Node tmp =firstKth.next;
            firstKth.next =lastKth.next;
            lastKth.next = tmp;

        }else {
            return  null;
        }

        return head;
    }


    public static void main( String [] args){
        int [][] arr = {
                { 1,2,3,4,7,0},
                {1,2,4,7,0},
                {1,2,3,4,7,0},
                {4}
                };

        Node head;
        Node modHead;

        head= createList( arr[0] );
        printList("Original list :", head);
        modHead = swapKNodeInList(head,2);
        printList("Swapped 2 position from both end of the  list :", modHead);

        head= createList( arr[1] );
        printList("Original list :", head);
        modHead = swapKNodeInList(head,3);
        printList("Swapped 3 position from both end of the  list :", modHead);

        head= createList( arr[2] );
        printList("Original list :", head);
        modHead = swapKNodeInList(head,5);
        printList("Swapped 5 position from both end of the  list :", modHead);

        head= createList( arr[3] );
        printList("Original list :", head);
        modHead = swapKNodeInList(head,1);
        printList("Swapped 1 position from both end of the  list :", modHead);
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
