package com.dynamic;

/*
here are n stairs, a person standing at the bottom wants to reach the top. The person can
climb either 1 stair or 2 stairs at a time. Count the number of ways, the person can reach the
top.
Input: n = 1
Output: 1
There is only one way to climb 1 stair
Input: n = 2
Output: 2
There are two ways: (1, 1) and (2)
Input: n = 4
Output: 5
(1, 1, 1, 1), (1, 1, 2), (2, 1, 1), (1, 2, 1), (2, 2)
Solve the problem for general case i.e. For N stairs, and different kinds of steps that can be
taken (e.g. instead of only 1 or 2 steps, it could be 2, 3 and 5 steps at a time)
Source and Solution: http://www.geeksforgeeks.org/count-ways-reach-nth-stair/
 */
public class ClimbStair {

    private static int climCount(int n){
        int [] dp = new int [n+1];
        dp[0] =1;
        dp[1] =1;

        for (int i=2; i<=n;i++){
            dp[i] = dp [i-1] + dp [i-2];
        }
        return dp[n];
    }

    public static void main(String [] args){
        int n =4;
        System.out.println(climCount(4));
    }
}
