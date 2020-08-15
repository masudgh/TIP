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


    private static int [] mergeArrays(int [][] arrays){

        Queue<Integer> pq = new PriorityQueue<>();

        int k = arrays.length; //Total Number of array
        int size = 0;
        for (int i = 0; i < k; i++) {
            size += arrays[i].length;
        }
        int [] result = new int [size];  //Sorted Array container

        for (int[] row : arrays) {
            for (int val : row) {
                pq.add(val);
            }
        } //T = O( n log n )

        Iterator<Integer> it = pq.iterator();

        int j=0;
        while(it.hasNext()){
            result[j++] = pq.poll();
        }

        return result;
    }



    private static class HeapNode implements Comparable<HeapNode>{
        int val;
        int arrIndex;
        int elemIndex;

        public HeapNode(int arrIndex, int elemIndex, int val) {
            this.val = val;
            this.arrIndex = arrIndex;
            this.elemIndex = elemIndex;
        }

        @Override
        public int compareTo(HeapNode otherNode) {
            if( this.val > otherNode.val ) {
                return 1;
            }else if (otherNode.val > this.val){
                return -1;
            }else{
                return 0;
            }
        }
    }



    private static int [] mergeArraysEff(int [][] arrays){


        int k = arrays.length;  //Total Number of array
        int size = 0;

        for (int i = 0; i < k; i++) {
            size += arrays[i].length;
        }
        int [] result = new int [size];  //Sorted Array container

        Queue<HeapNode> minHeap = new PriorityQueue<>(k);  // k size  Heap structure
        for (int arrayIndex=0; arrayIndex<k; arrayIndex++) {
            minHeap.offer (new HeapNode(arrayIndex, 0, arrays[arrayIndex][0]));
        }

        int i =0;
        while(!minHeap.isEmpty()){
            HeapNode tmpNode = minHeap.poll();
            result[i++] = tmpNode.val;

            if(tmpNode.elemIndex +1 < arrays[tmpNode.arrIndex].length){
                minHeap.offer( new HeapNode(
                        tmpNode.arrIndex,
                        tmpNode.elemIndex + 1,
                        arrays[tmpNode.arrIndex][tmpNode.elemIndex +1]
                ));
            }
        }

        return result;
    }


    static class Node {
        int value;
        int ary;

        Node(int value, int ary) {
            this.value = value;
            this.ary = ary;
        }
    }

    static class NodeComparator implements Comparator<Node> {
        boolean isAsc = false;

        public NodeComparator(boolean isAsc) {
            this.isAsc = isAsc;
        }

        public int compare(Node n1, Node n2) {
            if(n1.value < n2.value) {
                if(isAsc)
                    return -1;
                else
                    return 1;
            } else if(n1.value > n2.value) {
                if(isAsc)
                    return 1;
                else
                    return -1;
            } else {
                return 0;
            }
        }
    }

    static int[] mergearraysIQBAL(int[][] iarray) {
        int k = iarray.length;
        int n = iarray[0].length;


        int size = 0;
        for (int j = 0; j < k; j++) {
            size += iarray[j].length;
        }
        int[] result = new int[size];

        int[] ptrs = new int[k];
        Boolean isAsc = true;

        for(int j=0; j<k; j++) {
            if(iarray[j][0] < iarray[j][iarray[j].length-1]) {
                isAsc = true;
                break;
            } else if(iarray[j][0] > iarray[j][iarray[j].length-1]) {
                isAsc = false;
                break;
            }
        }

        PriorityQueue<Node> minHeap = new PriorityQueue<Node>(k, new NodeComparator(isAsc));
        for(int j=0; j<k; j++) {
            Node node = new Node(iarray[j][0], j);
            minHeap.offer(node);
        }

        int i=0;
        while(!minHeap.isEmpty()) {
            Node node = minHeap.poll();
            result[i++] = node.value;
            int ary = node.ary;
            if(++ptrs[ary] < iarray[ary].length) {
                int nextVal = iarray[ary][ptrs[ary]];
                minHeap.offer(new Node(nextVal, ary));
            }

        }
//        System.out.println(Arrays.toString(result));

        return result;
    }

    public static void main(String [] args){
       int [] [] arrays1 = {
                {1, 3} ,
                {2, 4, 6},
                {0, 9, 10, 11}
                };

        int [] [] arrays2 = {
                {1, 3, 20},
                {2, 4, 6}
        };


        int[][] arrays3 = {
                {-7, -5, -3,-1},
                {-10, -8, -6, -2},
        };


        int [] [] arrays4   = {
                {1, 3, 20},
                {1, 4, 6}
        };

        int[][] arrays5 = {
                {100,200,300,400},
                {10,20},
                {1,2,3,4 },
        };



        // n*log(n) sol
        int [] result1 = mergeArrays(arrays1);
        int [] result2 = mergeArrays(arrays2);
        int [] result3 = mergeArrays(arrays3);
        int [] result4 = mergeArrays(arrays4);
        int [] result5 = mergeArrays(arrays5);

        System.out.println (" n *log n solutions...... ");
        printResult(result1);
        printResult(result2);
        printResult(result3);
        printResult(result4);
        printResult(result5);


        // nlog(k) sol - Order dependence
        int [] result6 = mergeArraysEff(arrays1);
        int [] result7 = mergeArraysEff(arrays2);
        int [] result8 = mergeArraysEff(arrays3);
        int [] result9 = mergeArraysEff(arrays4);
        int [] result10 = mergeArraysEff(arrays5);
        System.out.println (" n *log k solutions [Order dependent] ...... ");
        printResult(result6);
        printResult(result7);
        printResult(result8);
        printResult(result9);
        printResult(result10);


        int[][] arrays6 = {
                {400,300,200,100},
                {20,10},
                {4,3,2,1 },
        };

        int [] [] arrays7   = {
                {1, 3, 20},
                {1, 4, 6}
        };

        // nlog(k) sol - Order independence
        int [] result11 = mergearraysIQBAL(arrays6);
        int [] result12 = mergearraysIQBAL(arrays7);

        System.out.println (" n *log k solutions [Order independent] ...... ");
        printResult(result11);
        printResult(result12);

    }

    private static void printResult(int [] arr){
        System.out.println(Arrays.toString(arr));
    }
}


