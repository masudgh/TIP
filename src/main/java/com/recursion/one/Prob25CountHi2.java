package com.recursion.one;

public class Prob25CountHi2 {

    public int countHi2(String str) {
        if (str.isEmpty()) return 0;

        int count =0;
        int n = str.length();
        if (n<2) return 0;

        String strHI;
        String remStr = str.substring(1);

        if(n>=3) {
            if ( !str.substring(0, 1).equals("x") ){
                if( str.substring(1, 3).equals("hi") ) {
                    count++;
                    if(str.length()>3)
                        remStr = str.substring(3);
                    else
                        remStr ="";
                }
                if( str.substring(0,2).equals("hi") ) {
                    count++;
                    remStr = str.substring(2);
                }
            }else if ( str.substring(0, 1).equals("x") ) {
                if( str.substring(1,3).equals("hi") ) {
                    if(str.length()>3)
                        remStr = str.substring(3);
                    else
                        remStr ="";
                }
            }else if( str.substring(0,2).equals("hi") ) {
                count++;
                remStr = str.substring(2);
            }


        }else{
            strHI = str.substring(0, 2);
            if (strHI.equals("hi")) count++;

        }
        return countHi2(remStr) +count;
    }

}
