package com.homework.Recursive;

import java.util.*;

/*
Given an array of ints, is it possible to choose a group of some of the ints, such that the group
sums to the given target?
Create a Recursion Tree to support you solution.

groupSum(0, [2, 4, 8], 10) → true
groupSum(0, [2, 4, 8], 14) → true
groupSum(0, [2, 4, 8], 9) → false
 */
public class HW5GroupSum2 {

    private static boolean groupSum(int []  arr, int [] count, int i, int target) {

        if (i == arr.length)
            return target ==0;

        boolean flag1 = false;
        if(i+1<count.length &&   count[i+1]>0) {
            count[i+1]--;
            flag1 = groupSum(arr, count, i + 1, target);
        }

        boolean flag2 = false;
        if( i<count.length &&   count[i]>0) {
            count[i]--;
            flag2 = groupSum(arr, count, i + 1, target - arr[i]);
        }
        return flag1 || flag2;

    }

    private  static void printSubset(int [] money, int []count){

        for(int i=0;i<5;i++){
            System.out.println( "$" + money[i] +", count: " +( 10- count[i]));
        }
    }




    static boolean[][] dp;



    // A recursive function to print all subsets with the
    // help of dp[][]. Vector p[] stores current subset.
    static void getSubsetsRec(int arr[], int i, int sum,
                              ArrayList<Integer> p, TreeMap<Integer, HashMap<Integer,Integer>> map)
    {
        // If we reached end and sum is non-zero. We print
        // p[] only if arr[0] is equal to sun OR dp[0][sum]
        // is true.
        if (i == 0 && sum != 0 && dp[0][sum])
        {
            p.add(arr[i]);
            upDateSubSetMap(p,map);
            p.clear();
            return;
        }

        // If sum becomes 0
        if (i == 0 && sum == 0)
        {
            upDateSubSetMap(p,map);
            p.clear();
            return;
        }

        // If given sum can be achieved after ignoring
        // current element.
        if (dp[i-1][sum])
        {
            // Create a new vector to store path
            ArrayList<Integer> b = new ArrayList<>();
            b.addAll(p);
            getSubsetsRec(arr, i-1, sum, b, map);
        }

        // If given sum can be achieved after considering
        // current element.
        if (sum >= arr[i] && dp[i-1][sum-arr[i]])
        {
            p.add(arr[i]);
            getSubsetsRec(arr, i-1, sum-arr[i], p, map);
        }
    }

    // Prints all subsets of arr[0..n-1] with sum 0.
    static void getAllSubsets(int arr[], int n, int sum, TreeMap<Integer, HashMap<Integer,Integer>> map )
    {
        if (n == 0 || sum < 0)
            return;

        // Sum 0 can always be achieved with 0 elements
        dp = new boolean[n][sum + 1];
        for (int i=0; i<n; ++i)
        {
            dp[i][0] = true;
        }

        // Sum arr[0] can be achieved with single element
        if (arr[0] <= sum)
            dp[0][arr[0]] = true;

        // Fill rest of the entries in dp[][]
        for (int i = 1; i < n; ++i)
            for (int j = 0; j < sum + 1; ++j)
                dp[i][j] = (arr[i] <= j) ? (dp[i-1][j] ||
                        dp[i-1][j-arr[i]])
                        : dp[i - 1][j];
        if (dp[n-1][sum] == false)
        {
            System.out.println("There are no subsets with" +
                    " sum "+ sum);
            return;
        }

        // Now recursively traverse dp[][] to find all
        // paths from dp[n-1][sum]
        ArrayList<Integer> p = new ArrayList<>();
        getSubsetsRec(arr, n-1, sum, p, map);
    }


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



    public  static void main(String [] args){
/*
        int []  money = {1,5,10,20,100};
        int [] count = {10,10,10,10,10};
        int target =7;

        int [] subset = new int [10];

        boolean flag =  groupSum(money,count,0,target);
        if(flag) {
            printSubset(money, count);
        }else{
            System.out.println("Insufficient fund!!! ");
        }
*/

        int arr[] = {1, 1,1,1,1,1,1,1,1,1,
                5,5,5,5,5, 5,5,5,5,5,
                10,10,10,10,10,10,10,10,10,10,
                20,20,20,20,20,20,20,20,20,20,
                100,100,100,100,100, 100,100,100,100,100
        };

        TreeMap<Integer, HashMap<Integer,Integer>> map = new TreeMap<>();
        int n = arr.length;
        int sum = 33;
        getAllSubsets(arr, n, sum, map);

        Map.Entry<Integer, HashMap<Integer, Integer>> bills = map.pollFirstEntry();
        if(bills != null){
            HashMap<Integer, Integer> minCountBills = bills.getValue();


            for (Map.Entry<Integer, Integer> entry : minCountBills.entrySet()) {
                System.out.println( "$"+entry.getKey() + " -> " + entry.getValue());
            }
        }



    }
}
