package com.recursion.one;

public class Prob21CountPairs {
    public int countPairs(String str) {
        if (str == null || str == "" ) return 0;
        if( str.length() <= 2) return 0;

        String str1 = str.substring(0,3);
        String [] tmp =str1.split("");

        if(tmp[0].equals(tmp[2]) /*&& !tmp[0].equals(tmp[1])*/)
        {
            return 1+ countPairs(str.substring(1));
        }else{
            return countPairs(str.substring(1));
        }
    }



}
