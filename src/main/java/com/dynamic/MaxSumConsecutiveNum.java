package com.dynamic;

public class MaxSumConsecutiveNum {

    public static int consecutiveSum(int [] arr){

        return consecutiveSum( arr,0,  0);
    }

    public static int maxSum =0;

    public static int consecutiveSum(int [] arr, int i, int sum){
        int n = arr.length;

        if( i >= n ) return sum;

        int sum1 =0;
        int sum2 =0;
if(i ==4){
    System.out.println(" this is");
}
        if( i+1 < n ){
            if( i != n-1 ){
               if (  arr [i+1] -arr[i]  == 1  ){
                    sum1 = consecutiveSum(arr, i + 1, sum + arr[i]);
                }else{
                   sum2 = consecutiveSum( arr,  i+1,  sum);
               }
            }else{
               if(( arr [i] -arr[i-1] ) ==1 ){
                   sum1 = consecutiveSum(arr, i + 1, sum + arr[i]);
               }else{
                   sum2 = consecutiveSum( arr,  i+1,  sum);
               }
            }
        }else{
            sum2 = consecutiveSum( arr,  i+1,  sum);
        }

        if( sum1 > sum2){
            sum+=sum1;
        }else{
            sum+=sum2;
        }

        if(maxSum < sum){
            maxSum = sum;
        }

        return sum;
    }


    public static int consecutiveSum2(int [] arr){
        int maxSum =0;
        for(int i=0; i< arr.length-1 ; i++){
            if( (arr[i+1] - arr[i]) ==1 )
            {
               if( (arr[i+1] + arr[i]) > maxSum){
                   maxSum = (arr[i+1] + arr[i]);
               }
            }
        }
        return maxSum;
    }

    public static void main (String [] args){
        int [] arr ={ 8,99,100,9,10};
        maxSum = consecutiveSum2 (arr);

        System.out.println(maxSum);
    }
}
