package com.treeWork.quiz;

import java.util.LinkedList;
import java.util.Queue;

public class ArrayToTree {


    private static Node toTree(int [] arr){

        if(arr == null) return null;
        if(arr.length ==1) return new Node(arr[0]);
        return createTree(0, arr.length-1,arr);
    }

    // Use merge sort idea to create the tree, Since it is sorted, the root is the mid point
    private static Node createTree(int left, int right, int[] arr) {
        if (right - left < 0) return null;
        int mid = left + ((int) Math.ceil((right - left) / 2f));  // root
        return new Node(arr[mid],
                createTree(left,mid-1, arr),
                createTree(mid+1,right, arr));
    }

    static class Node {
        Node left, right;
        int value;
        Node( int value) {
            this.left = null;
            this.right = null;
            this.value = value;
        }

        Node( int value, Node left, Node right) {
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }

    public static void main (String [] ags) {
        int [] arr = {-10,-3,0,5,9};
        Node root = toTree(arr);
        printLevelOrderUseOneQueandCount(root);  //Check how they look like
    }


    // 5) Level order --(use BFS, single queue using count)
    private static void printLevelOrderUseOneQueandCount(Node node) {
        if(node == null) return;
        Queue<Node> q1 = new LinkedList<>();
        q1.add(node);

        while(true){

            int levelNodeCount= q1.size();
            if(levelNodeCount==0) break;

            while(levelNodeCount>0) {

                if (q1.peek().left != null) {
                    q1.add(q1.peek().left);

                }

                if (q1.peek().right != null) {
                    q1.add(q1.peek().right);
                }

                System.out.print(q1.peek().value + " ");
                q1.remove();
                levelNodeCount--;
            }

            System.out.println();
        }
    }
}
