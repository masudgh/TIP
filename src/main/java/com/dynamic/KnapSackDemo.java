package com.dynamic;

import java.util.Arrays;

public class KnapSackDemo {


    public static int knapsack(int [] wt, int [] val, int w){
        return knapsack( wt,  val, wt.length , w);
    }


    public static int knapsack(int [] wt, int [] val, int i, int w){

        if (i <= 0 ) return 0;
        if( w ==0) return 0;

        if(wt[i-1] > w) return knapsack(wt,val,i-1,w);

        return Math.max(
                knapsack(wt,val,i-1, w),
                val[i-1] + knapsack(wt,val,i-1,w-wt[i-1])
        );
    }

    public static int knapsackDP(int [] wt, int [] val, int w){
        int [] [] dp = new int [wt.length+1][w+1];

        Arrays.fill(dp[0], 0);

        for(int i =0; i <dp.length; i++){
            dp[i][0] =0;
        }


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
     /*   int [] wt = {1,2,3};
        int [] val = {16,10,12};
        int w = 5;


        int maxVal = knapsack(wt,val,w);

        System.out.println("Max value " + maxVal+ " within weight "+w);

        maxVal = knapsackDP(wt,val,w);
        System.out.println("Max value " + maxVal+ " within weight "+w);


        int [] wt2 = {12,1,2,1,4};
        int [] val2 = {4,2,2,1,10};

        w = 15;

        maxVal = knapsack(wt2,val2,w);

        System.out.println("Max value " + maxVal+ " within weight "+w);

        maxVal = knapsackDP(wt2,val2,w);
        System.out.println("Max value " + maxVal+ " within weight "+w);

      */

        int [] moneyWt = {1,5,10,20,100};
        int [] moneyCount = {1,5,10,20,100};

        int betAmount = 50;


        int maxVal = knapsackDP(moneyWt,moneyCount,betAmount);
        System.out.println("Pay amount  " + maxVal+ " for bet amount "+betAmount);

    }


}
