package com.llstq;

import jdk.nashorn.internal.runtime.regexp.joni.constants.StackPopLevel;

import java.util.Stack;

public class MinStack {

    public static class MinStackImp {
        Stack<Integer> stack ;
        private int minVal = Integer.MAX_VALUE;

        public MinStackImp() {
            stack = new Stack<>();
        }


        public void push(Integer item) {
            if(item<minVal) minVal = item;
            stack.push(item);
        }


        public synchronized Integer pop() {
            return stack.pop();
        }


        public synchronized Integer peek() {
            return stack.peek();
        }


        public boolean empty() {
            minVal = Integer.MAX_VALUE;
            return stack.empty();
        }

        public void clear() {
            minVal = Integer.MAX_VALUE;
            stack.clear();
        }

        public synchronized int search(Object o) {
            return stack.search(o);
        }


        public Integer getMin(){
            if(stack.isEmpty()) return null;
            return minVal;
        }
    }



    public static void main( String [] args){

        MinStackImp stack = new MinStackImp();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println( stack.getMin());
        stack.clear();


        stack = new MinStackImp();
        stack.push(1);
        stack.push(5);
        stack.push(3);
        stack.push(0);
        System.out.println( stack.getMin());
        stack.clear();


        System.out.println( stack.getMin());


    }
}
