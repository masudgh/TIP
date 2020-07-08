package com.recursion.one;

public class Prob22CountAbc {
    public int countAbc(String str) {
        if (str == null || str == "" ) return 0;
        if( str.length() <= 2) return 0;

        String str1 = str.substring(0,3);
        String [] tmp =str1.split("");

        if(str1.equals("abc") || str1.equals("aba") )
        {
            return 1+ countAbc(str.substring(1));
        }else{
            return countAbc(str.substring(1));
        }
    }
}
