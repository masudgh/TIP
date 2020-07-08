package com.recursion.one;

public class Prob23Count11 {
    public int count11(String str) {

        if (str == null || str == "" ) return 0;
        if( str.length() <= 1) return 0;
        String str1 = str.substring(0,2);


        if(str1.equals("11") )
        {
            return 1+ count11(str.substring(2));
        }else{
            return count11(str.substring(1));
        }

    }

}
