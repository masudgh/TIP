package com.recursion.one;

public class Prob20EndX {
    public String endX(String str) {
        if (str == null || str == "" ) return "";
        String strX =  str.substring(0,1);
        String str2=null;

        if(str.length() >1)
            str2 = str.substring(1);


        if(strX.equals( "x")) {
            return endX(str2) + strX;
        }else{
            return strX + endX(str2);
        }
    }

}
