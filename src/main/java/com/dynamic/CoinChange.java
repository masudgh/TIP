package com.dynamic;

import java.util.*;

public class CoinChange {


    public static int findMinNumberCoins0(int [] coins, int target){

        if (target == 0) return 0;
        int coinLength = coins.length+1;
        int targetAmount = target +1;
        int [] [] dp = new int [coinLength][targetAmount];
        Map<Integer, Map<Integer,Integer>> minCoinMap = new TreeMap<>();
        Map<Integer,Integer> minCoins = new HashMap<>();

        for(int row =0; row< coinLength; row++){
            dp[row][0] = 0;
        }
        for(int col =0; col< targetAmount; col++){
            dp[0][col] = Integer.MAX_VALUE-1; //Important, but has drawback
        }

        for(int row =1; row < coinLength; row++){
            for(int col=1; col<targetAmount; col++){
               if (col >= coins[row-1]){
                    dp[row][col] = Math.min(dp[row-1][col], 1 + dp[row][col-coins[row-1]]);
               }else{
                   dp[row][col] = dp[row-1][col];
               }
            }
        }
        return dp[coinLength-1][targetAmount-1];
    }

    public static int findMinNumberCoins(int [] coins, int target){

        if (target == 0) return 0;

        Arrays.sort(coins);

        int coinLength = coins.length+1;
        int targetAmount = target +1;
        int [] [] dp = new int [coinLength][targetAmount];
        Map<Integer, Map<Integer,Integer>> minCoinMap = new TreeMap<>();
        Map<Integer,Integer> minCoins = new HashMap<>();

        for(int row =0; row< coinLength; row++){
            dp[row][0] = 0;
        }
        for(int col =0; col< targetAmount; col++){
            dp[0][col] = Integer.MAX_VALUE-1; //Important, but has drawback
        }

        for(int row =1; row < coinLength; row++){
            for(int col=1; col<targetAmount; col++){
                if (col >= coins[row-1]){
                    dp[row][col] = Math.min(dp[row-1][col], 1 + dp[row][col-coins[row-1]]);
                }else{
                    dp[row][col] = dp[row-1][col];
                }
            }
        }
        return dp[coinLength-1][targetAmount-1];
    }

    private static int makeChange(int [] coins, int value) {
        Map<Integer,Integer> changeTable = new HashMap<>();

        for (int i = 1; i <= value; i++) {
            for (int coin : coins) {

                if (i - coin == 0) {
                    changeTable.put(i, 1);
                } else if (i - coin > 0) {
                    if (changeTable.containsKey(i)) {
                        if (changeTable.get(i) > changeTable.get(i - coin) + 1) {
                            changeTable.put(i, 1 + changeTable.get(i - coin));
                        }
                    } else {
                        changeTable.put(i, 1 + changeTable.get(i - coin));
                    }
                }
            }
        }
        return changeTable.get(value);
    }








    // Update or Add subset to the   TreeMap
    private boolean upDateSubSetMap(List<Integer> p, TreeMap<Integer, HashMap<Integer,Integer>> map){

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

    public static void  printMap(Map<Integer, Integer> map){
        for(Map.Entry<Integer, Integer > mapEntry: map.entrySet()){
            System.out.println(mapEntry.getKey() + " , "+mapEntry.getValue());
        }
    }


    public static int[] minChange(int[] denom, int changeAmount)
    {
        int n = denom.length;
        int[] count = new int[changeAmount + 1];
        int[] from = new int[changeAmount + 1];

        count[0] = 1;
        for (int i = 0 ; i < changeAmount; i++)
            if (count[i] > 0)
                for (int j = 0; j < n; j++)
                {
                    int p = i + denom[j];
                    if (p <= changeAmount)
                    {
                        if (count[p] == 0 || count[p] > count[i] + 1)
                        {
                            count[p] = count[i] + 1;
                            from[p] = j;
                        }
                    }
                }

        // No solutions:
        if (count[changeAmount] == 0)
            return null;

        // Build answer.
        int[] result = new int[count[changeAmount] - 1];
        int k = changeAmount;
        while (k > 0)
        {
            result[count[k] - 2] = denom[from[k]];
            k = k - denom[from[k]];
        }

        return result;
    }

    public static void main(String [] args) {
        int[] denominations1 = {1, 8, 1,1,5};
        int target1 = 11;
      //  System.out.println(findMinNumberCoins(denominations, target));

        int[] denominations2 = {2, 3, 4,1, 6};
        int target2 = 5;
        System.out.println(findMinNumberCoins(denominations1, target1));

        System.out.println( Arrays.toString(minChange(denominations1, target1)) );
        //printMap(findMinNumberCoins(denominations, target));

    }


    public static void  printMap(TreeMap<Integer, HashMap<Integer,Integer>> map){

        if(map == null) return;  //  NO SUBSET IS POSSIBLE

        for(Map.Entry<Integer, HashMap<Integer, Integer> > treeMapEntry: map.entrySet()){
            HashMap<Integer,Integer> changes = treeMapEntry.getValue();
            System.out.println("Combination "+ treeMapEntry.getKey());
            for(Map.Entry<Integer, Integer> entry: changes.entrySet() ){
                System.out.println(entry.getKey() + " , "+entry.getValue());
            }
        }
    }
}
