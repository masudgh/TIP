package com.llstq;

import java.util.Stack;

public class StackSequence {

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
