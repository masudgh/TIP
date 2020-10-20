package com.dynamic;

/*
Given weights and values of n items, put these items in a knapsack of capacity W
to get the maximum total value in the knapsack. In other words, given two integer arrays
val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items respectively.
 Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such
 that sum of the weights of this subset is smaller than or equal to W. You cannot break an item, either pick the
 complete item or don’t pick it (0-1 property).

https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
 */

public class KnapSackDemo {


    //Recursive method
    public static int knapsack(int [] wt, int [] val, int w){
        return knapsack( wt,  val, wt.length , w);
    }


    //Recursive method
    public static int knapsack(int [] wt, int [] val, int i, int w){

        if (i <= 0 ) return 0;
        if( w ==0) return 0;

        if(wt[i-1] > w) return knapsack(wt,val,i-1,w);

        return Math.max(
                knapsack(wt,val,i-1, w),
                val[i-1] + knapsack(wt,val,i-1,w-wt[i-1])
        );
    }

    //DP method
    public static int knapsackDP(int [] wt, int [] val, int w){
        int [] [] dp = new int [wt.length+1][w+1];

        for(int i =1; i< dp.length; i++){
            for(int j =0; j <= w; j++){
                if(wt[i-1] > j) {
                    dp[i][j] =dp[i-1][j];
                }else{
                    dp[i][j] =  Math.max(
                        dp[i-1][j],
                        val[i-1] + dp [i-1][ j- wt[i-1]]
                    );
                }
            }
        }
        return dp[dp.length-1][w];
    }

    public static void main(String [] args){


        int [] weights = {1,5,10,20,100};
        int [] values = {1,5,10,20,100};

        int weightLimit = 50;
        int [] weights2 = {10,20,30};
        int [] values2 = {60,100,120};

        int maxVal = knapsackDP(weights2,values2,weightLimit);
        System.out.println("Max Value   " + maxVal+ " for the limit of weight "+weightLimit);

    }


}
