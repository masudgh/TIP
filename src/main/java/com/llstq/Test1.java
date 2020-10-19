package com.llstq;



/*
Given two sequences pushed and popped with distinct values, return true if and only if this could have been the result of a sequence of push and pop operations on an initially empty stack.

Example 1:

Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
Output: true
Explanation: We might do the following sequence:
push(1), push(2), push(3), push(4), pop() -> 4,
push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
Example 2:

Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
Output: false
Explanation: 1 cannot be popped before 2.

Method signature:
public boolean validateStackSequences(int[] pushed, int[] popped)

Solution:
https://leetcode.com/problems/validate-stack-sequences/
(for later reference)
 */

import java.util.Stack;

public class Test1 {

    private static boolean validateSequence(int [] pushed, int [] popped){

        Stack<Integer> stk = new Stack<>();
        int l1 = pushed.length;
        int l2 = popped.length;

        int j =0 ;
        stk.push(pushed[0]);
        int i =1;
        while (i<l1 && j<l2){

            if (stk.peek()== popped[j] ){
                stk.pop();
                j++;
            }else {
                stk.push(pushed[i++]);
            }
            while(i==l1 &&  j<l2 && stk.peek()== popped[j]){
                stk.pop();
                j++;
            }
        }

        return stk.empty();
    }

    public static void main(String [] args){
        int [] arr1 = {1,2,3,4,5};
        int [] arr2 = {4,5,3,2,1};

        boolean flag1 = validateSequence(arr1, arr2);
        System.out.println(flag1);

        int [] arr3 = {1,2,3,4,5};
        int [] arr4 = {4,3,5,1,2};

        boolean flag2 = validateSequence(arr3, arr4);

        System.out.println(flag2);
    }
}