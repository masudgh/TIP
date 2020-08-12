package com.llstq;

import java.util.*;

/*

Given k sorted arrays of possibly different sizes, merge them and print the sorted output.
Input: k = 3
      arr[][] = { {1, 3},
                  {2, 4, 6},
                  {0, 9, 10, 11}} ;
Output: 0 1 2 3 4 6 9 10 11

Input: k = 2
      arr[][] = { {1, 3, 20},
                  {2, 4, 6}} ;
Output: 1 2 3 4 6 20

 */
public class MergeKArrays {


    private static void mergeArrays(int [][] arrays){

        Queue<Integer> pq = new PriorityQueue<>();

        int r = arrays.length;

        for (int[] row : arrays) {
            for (int val : row) {
                pq.add(val);
            }
        } //T = O( n log n )

        Iterator<Integer> it = pq.iterator();

        System.out.print("Sorted Array: ");
        while(it.hasNext()){
            int val = pq.poll();
            System.out.print(val+ ", ");
        }
        System.out.println();
    }


    private static void mergeArraysEff(int [][] arrays){

        Queue<Integer> pq = new PriorityQueue<>();
        List<Integer> sortedArr = new ArrayList<>();
        int i = 0;
        while(true) { // No of integer == n
            for (int[] arr : arrays) {
                if(i<arr.length)
                    pq.add(arr[i]);
            }
            if(pq.isEmpty()) break;

            while(!pq.isEmpty()){
                sortedArr.add(pq.poll()); // no of array == log K
            }
            i++;
        }

        //T = O( n log K )

        System.out.print("Sorted Array: ");
        for (Integer val : sortedArr) {
            System.out.print(val + ", ");
        }
        System.out.println();
    }



    public static void main(String [] args){
        int [] [] arrays1 = {
                {1, 3} ,
                {2, 4, 6},
                {0, 9, 10, 11}
                };
        mergeArraysEff(arrays1);


        int [] [] arrays2 = {
                {1, 3, 20},
                {2, 4, 6}
        };
        mergeArraysEff(arrays2);

        int[][] arrays3 = {
                {-1,-3,-5,-7},
                {-2,-6,-8,-10},
        };
        mergeArraysEff(arrays3);

        int [] [] arrays4   = {
                {1, 20, 3},
                {1, 6, 4}
        };
        mergeArraysEff(arrays4);

    }
}
