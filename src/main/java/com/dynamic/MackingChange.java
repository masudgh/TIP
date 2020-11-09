package com.dynamic;

import java.util.*;

/*
You are given n types of coin denominations of values v(1) < v(2) < ... < v(n) (all
integers). Give an algorithm which makes change for an amount of money C with as few coins
as possible.
* Assume there are multiple coins of every denomination.
* Assume v(1) = 1, (i.e. there is always a combination that leads to C).
* There may be multiple ways of reaching C. We want a DP based solution that leads to the
method using least number of coins.
* Input: C and Denominations Array
* Output: Combination using minimum number of coins (repeat coins ok) that leads to C. Print
any one.
Variation: There may be multiple such combinations. Print all such
combinations. Hint: You'll need to do recursion on the DP table.
e.g.
Input:
Denominations: 1,2,3
C: 4
Output on two lines:
1,3
2,2

Solution with explanation: https://discuss.leetcode.com/topic/35720/easy-to-understandrecursive-dp-solution-using-java-with-explanations
More efficient solution, but with no explanation: https://discuss.leetcode.com/topic/32475/c-on-amount-time-o-amount-space-dp-solution/4

 */
public class MackingChange {

    private static boolean[][] dp;

    // A recursive function to print all subsets with the
    // help of dp[][]. Vector p[] stores current subset.
    private static void getSubsetsRec(int arr[], int i, int target,
                                      ArrayList<Integer> p, TreeMap<Integer, HashMap<Integer,Integer>> map)
    {
        // If we reached end and sum is non-zero. We print
        // p[] only if arr[0] is equal to sun OR dp[0][sum]
        // is true.
        if (i == 0 && target != 0 && dp[0][target])
        {
            p.add(arr[i]);
            upDateSubSetMap(p,map);
            p.clear();
            return;
        }

        // If sum becomes 0
        if (i == 0 && target == 0)
        {
            upDateSubSetMap(p,map);
            p.clear();
            return;
        }

        // If given sum can be achieved after ignoring
        // current element.
        if (dp[i-1][target])
        {
            // Create a new vector to store path
            ArrayList<Integer> b = new ArrayList<>();
            b.addAll(p);
            getSubsetsRec(arr, i-1, target, b, map);
        }

        // If given sum can be achieved after considering
        // current element.
        if (target >= arr[i] && dp[i-1][target-arr[i]])
        {
            p.add(arr[i]);
            getSubsetsRec(arr, i-1, target-arr[i], p, map);
        }
    }

    // Get all subsets of arr[0..n-1] with sum 0.
    private static void getAllSubsets(int arr[], int n, int target, TreeMap<Integer, HashMap<Integer,Integer>> map )
    {
        if (n == 0 || target < 0)
            return;

        // Sum 0 can always be achieved with 0 elements
        dp = new boolean[n][target + 1];
        for (int i=0; i<n; ++i)
        {
            dp[i][0] = true;
        }

        // Sum arr[0] can be achieved with single element
        if (arr[0] <= target)
            dp[0][arr[0]] = true;

        // Fill rest of the entries in dp[][]
        for (int i = 1; i < n; ++i)
            for (int j = 0; j < target + 1; ++j)
                dp[i][j] = (arr[i] <= j) ? (dp[i-1][j] ||
                        dp[i-1][j-arr[i]])
                        : dp[i - 1][j];
        if (dp[n-1][target] == false)  // No subset is possible
        {
            map =null;
            return;
        }

        // Now recursively traverse dp[][] to find all
        // paths from dp[n-1][sum]
        ArrayList<Integer> p = new ArrayList<>();
        getSubsetsRec(arr, n-1, target, p, map);
    }


    // Update or Add subset to the   TreeMap
    private static boolean upDateSubSetMap(List<Integer> p, TreeMap<Integer, HashMap<Integer,Integer>> map){

        int size = p.size();

        if(map.containsKey(size)) return false;

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0; i<size;i++){
            if(hashMap.containsKey(p.get(i))){
                int count = hashMap.get(p.get(i));
                hashMap.put(p.get(i), count +1 );
            }else{
                hashMap.put(p.get(i), 1 );
            }
        }
        map.put(size, hashMap);
        return true;
    }


    // This method will calculate a subset with sum is the value of the target. And this subset is the
    // minimum size of all other subset.
    public static TreeMap<Integer, HashMap<Integer,Integer>> findMinSubSetOfTarget(int [] arr, int target ){

        TreeMap<Integer, HashMap<Integer,Integer>> map = new TreeMap<>();
        int n = arr.length;

        getAllSubsets(arr, n, target, map);

        return map;

    }

    public static void  printMap(TreeMap<Integer, HashMap<Integer,Integer>> map){

        if(map == null) return;  //  NO SUBSET IS POSSIBLE

       /* Map.Entry<Integer, HashMap<Integer, Integer>> firstMapEntry = map.pollFirstEntry();
        HashMap<Integer, Integer> minSubSet = null;

        if( firstMapEntry!= null) {
            minSubSet = firstMapEntry.getValue();
        }

        return minSubSet;  //MIN LENGTH SUBSET FOR THE GIVEN TARGET

        */

        for(Map.Entry<Integer, HashMap<Integer, Integer> > treeMapEntry: map.entrySet()){
            HashMap<Integer,Integer> changes = treeMapEntry.getValue();
            System.out.println("Combination "+ treeMapEntry.getKey());
            for(Map.Entry<Integer, Integer> entry: changes.entrySet() ){
                System.out.println(entry.getKey() + " , "+entry.getValue());
            }
        }
    }

    public static void main(String [] args){
        int [] denominations = {1,2,2,3};
        int target = 4;
        printMap(findMinSubSetOfTarget(denominations, target));
      //  int finalCount = coinChange(denominations,target);
       // printMap(amountDict);
    }

    private static Map<Integer,Integer> amountDict = new HashMap<Integer,Integer>();
    public static int coinChange(int[] coins, int amount) {
        if(amount==0)
            return 0;
        if(amountDict.containsKey(amount))
            return amountDict.get(amount);
        int n = amount+1;
        for(int coin : coins) {
            int curr = 0;
            if (amount >= coin) {
                int next = coinChange(coins, amount-coin);
                if(next >= 0)
                    curr = 1+next;
            }
            if(curr > 0)
                n = Math.min(n,curr);
        }
        int finalCount = (n==amount+1) ? -1 : n;
        amountDict.put(amount,finalCount);
        return finalCount;
    }

}
