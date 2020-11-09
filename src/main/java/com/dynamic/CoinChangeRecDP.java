package com.dynamic;

import java.util.*;

public class CoinChangeRecDP {

    private static boolean[][] dp;

    // A recursive function to print all subsets with the
    // help of dp[][]. Vector path[] stores current subset.
    private static void getSubsetsRec(int coins[], int i, int target,
                               ArrayList<Integer> path, TreeMap<Integer, List<Integer>> map)
    {
        // If we reached end of coin list and sum is non-zero. We print
        // path[] only if coins[0] is equal to sum OR dp[0][target]
        // is true.
        if (i == 0 && target != 0 && dp[0][target])
        {
            path.add(coins[i]);
            upDateSubSetMap(path,map);
            path.clear();
            return;
        }

        // If sum becomes 0 and dp[0][target]
        // is true.
        if (i == 0 && target == 0 && dp[0][target])
        {
            upDateSubSetMap(path,map);
            path.clear();
            return;
        }

        // If given sum can be achieved after ignoring
        // current element.
        if (dp[i-1][target])
        {
            // Create a new list to store path
            ArrayList<Integer> b = new ArrayList<>();
            b.addAll(path);
            getSubsetsRec(coins, i-1, target, b, map);
        }

        // If given sum can be achieved after considering
        // current element.
        if (target >= coins[i] && dp[i-1][target-coins[i]])
        {
            path.add(coins[i]);
            ArrayList<Integer> b = new ArrayList<>();
            b.addAll(path);
            getSubsetsRec(coins, i-1, target-coins[i], b, map);
        }
    }

    // Get all subsets of coins[0..numOfCoins-1] with sum 0.
    private static void getAllSubsets(int coins[], int numOfCoins, int target, TreeMap<Integer, List<Integer>>map )
    {
        if (numOfCoins == 0 || target < 0) //Edge case, no coins
            return;

        // Sum 0 can always be achieved with 0 elements
        dp = new boolean[numOfCoins][target + 1];
        for (int i=0; i<numOfCoins; ++i)
        {
            dp[i][0] = true;
        }

        // Sum coins[0] can be achieved with single element
        if (coins[0] <= target)
            dp[0][coins[0]] = true;

        // Fill rest of the entries in dp[][]
        for (int i = 1; i < numOfCoins; ++i) { // Rows ... number of coins available
            for (int j = 1; j < target + 1; ++j) { // cols ... the target amount
                if( j >= coins[i]){
                    dp[i][j] = (dp[i - 1][j] || dp[i - 1][j - coins[i]]);
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        if (!dp[numOfCoins - 1][target])  // No subset is possible
        {
            map =null;
            return;
        }

        // Now recursively traverse dp[][] to find all
        // paths from dp[numOfCoins-1][sum]
        ArrayList<Integer> path = new ArrayList<>();
        getSubsetsRec(coins, numOfCoins-1, target, path, map);
    }


    // Update or Add subset to the   TreeMap
    private static boolean upDateSubSetMap(List<Integer> path, TreeMap<Integer, List<Integer>> map){

        int size = path.size();
        if(map.containsKey(size)) return false;
        map.put(size, new ArrayList<>(path));
        return true;
    }


    // This method will calculate a subset with sum is the value of the target. And this subset is the
    // minimum size of all other subset.
    public static void findMinSubSetOfTarget(int [] coins, int target ){

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        int numOfCoins = coins.length;

        getAllSubsets(coins, numOfCoins, target, map);

        List<Integer> minSubSet = null;

        for(Map.Entry<Integer, List<Integer> > treeMapEntry: map.entrySet()){
            List<Integer> changes = treeMapEntry.getValue();
            System.out.println("Number of coins: "+ treeMapEntry.getKey());
            prinList(changes);
        }
    }

    public static void main(String [] args){
        int [] denominations0 = {1,2,2,3};
        int target0 = 5;

        int[] denominations1 = {1, 8, 1,1,5, 3};
        int target1 = 11;

        findMinSubSetOfTarget(denominations0, target0);

    }

    public static void  prinList(List<Integer> list){
        if(list == null) return;
        StringJoiner sj = new StringJoiner(",");
        for (Integer s : list) {
            sj.add(String.valueOf(s));
        }
        System.out.println(sj.toString());
    }


}
