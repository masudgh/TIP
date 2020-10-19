package com.llstq;

import java.util.ArrayList;
import java.util.List;

/*
Assume you have a stream of integers which spits out a number every minute. At any given point of time you should be able to give the average of last 3 minutes of data.
Note: The interview question may end here and you will have to ask clarifying questions.

Another way this question could be asked:
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

eg:
Example:

MovingAverage m = new MovingAverage(3); // need average of last 3 minutes
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3

Implement the class MovingAverage, the constructor takes the window size and implements a method next() which takes the number (from the stream) and returns the average for the window.

Take inspiration from:
https://www.geeksforgeeks.org/program-find-simple-moving-average/
(for later reference)
 */
public class Test2 {

    public static class MovingAverage{
        int windowSize;
        List<Integer> list = new ArrayList<>();
        int windowStartPosition;


        public MovingAverage(int windowSize) {
            this.windowSize = windowSize;
            this.windowStartPosition =0;
        }

        public double next(int val){
            list.add(val);

            if(list.size()> windowSize) {
                list.remove(windowStartPosition);
               // windowStartPosition++;
            }
            double sum =0;
            int windowEndPosition = windowSize+ windowStartPosition;

            int count =0;
            for(int i = windowStartPosition; i<windowEndPosition && count<list.size(); i++){
                sum += list.get(i);
                count++;
            }
            return sum/count;
        }

    }

    public static void main(String [] args){
        MovingAverage m = new MovingAverage(3); // need average of last 3 minutes

        int[] arr = {1,10,3,5};
        for(int i: arr){
            System.out.println( m.next(i));
        }

    }
}
