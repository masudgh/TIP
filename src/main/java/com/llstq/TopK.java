package com.llstq;

import java.util.*;

/*
Problem statement: Find K largest elements from a given stream of numbers. By definition,
we don't know the size of the input stream. Hence produce K largest elements seen so far, at
any given time.
* Input may or may not be sorted and could have duplicates
* Represent input stream as an array. Don't rely on its size.
* Feel free to use built-in functions if you need a specific data-structure.
* If your output is correct, but a test-case is failing because order of output elements is
different, then don't worry about it. Move on.
=====
Interview time: 45 minutes
Solution(s): http://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/ (Solution
#6 is the only one that'll work when size of the input stream is not known)
[Trivia: When size of input array (stream) is known to be N, then either #5 or #6 will work.
Both solutions have same complexity, but #6 will work faster because it doesn't muck with the
entire input, and only deals with K elements separately]
 */
public class TopK {


    private static  void  findTopK(int [] arr, int k){
        if(arr == null) return;  //Boundary Condition

        int n = arr.length;
        if( n == 1) {  //Boundary Condition
            System.out.print("Top 1st number: ");
            System.out.print( arr[0] );
        }

        Queue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<k; i++){
            pq.add(arr[i]);
        }

        for(int i=n-k-1; i<n; i++){
            if(pq.peek()< arr[i]){
                pq.poll();
                pq.add(arr[i]);
            }
        }
        //Time complexity O(k + (n-k)Logk)
        System.out.print("Top kth number: ");
        while(pq.size() !=0) {
            System.out.print(pq.poll() + ", ");
        }

    }

    //main
    public static void main(String [] args){
        int [] arr = {1,23,12,9,30,2,50};
        findTopK(arr,3);

    }
}
