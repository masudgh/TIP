package com.recursion.one;

public class Prob14NoX {
    public String noX(String str) {
        if (str == null || str == "" ) return "";
        String strX =  str.substring(0,1);
        String str2=null;

        if(str.length() >1)
            str2 = str.substring(1);


        if(strX.equals( "x")) {
            return noX(str2);
        }else{
            return strX + noX(str2);
        }
    }

}
