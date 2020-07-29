package com.recursion.Quiz;

public class Quiz2 {


    private static boolean isEqualPartision(int[] arr) {
        if (arr.length ==0) return true;  //Special Case
        if (arr.length ==1) return false;  //Special case

        if(arr.length==2 )
            return arr[0] == arr[1];

        int sum = arr[0]+arr[1];
        return isEqualPartision( 1, arr, sum);
    }

    private static boolean isEqualPartision( int i, int [] arr, int sum){
        if(i== arr.length-1)
            return sum%2 == 0;  //When a series has partition , then the sum of them is divisible by 2

        i++;
        sum  +=arr[i];
        return isEqualPartision(i, arr, sum);

    }

    public static void main (String [] args){
        int [] list1 = {1, 5, 11, 5};
        System.out.println( isEqualPartision(list1) );

        int [] list2 ={1, 2, 3, 5};
        System.out.println( isEqualPartision(list2) );
    }
}
