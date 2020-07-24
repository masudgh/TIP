package com.heb;

import java.util.Arrays;

public class Prob1 {

    private static String mySentense(String str){
        if (str == null ) return null;
        if (str.isEmpty()) return null;

        String [] arr = str.trim().split("\\s");
        StringBuilder bld = new StringBuilder();
        int n = arr.length;
        for(int i=0;  i <n ; i++){
           // revSentence[i]= reverseStr(arr[i]);
            char[] tmp = arr[i].toCharArray();
            int len = tmp.length;
            bld.append( reverseStr( tmp,0,len-1) );
            bld.append(" ");
        }

        return bld.toString();
    }

    private static String reverseStr(String str){

        char [] arr = str.toCharArray();
        int n = arr.length;


        for(int i =0; i<n/2; i++){
            char tmp = arr[i];
            arr[i] = arr[n-1-i] ;
            arr[n-1-i] = tmp;
        }



        return new String(arr);
    }

    private static String reverseStr(char[] arr, int left, int right){

        if(left>= right) return String.valueOf(arr);

        char tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
        left++;
        right--;

        return reverseStr(arr,left,right);

    }



    public static void main(String[] args){

        String str = "I am cray about loving you";
        System.out.println("Reverse my string:--> "+ mySentense(str));
    }
}
