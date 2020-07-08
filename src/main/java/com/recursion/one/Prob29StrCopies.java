package com.recursion.one;

public class Prob29StrCopies {
    public boolean strCopies(String str, String sub, int n) {

        if(str.isEmpty() ) {
            if( n == 0) return true;

            return false;
        }
        int subLen = sub.length();
        if(subLen > str.length()) return false;
        int count =0;
        int nextLen = 1;
        int newCount = n;
        String str1 = str.substring(0,subLen);
        if(str.substring(0,subLen).equals(sub)){
            count++;
            //nextLen = subLen;
            newCount --;
            if(newCount==0) return true;
        }

        return (strCopies (str.substring(nextLen), sub, newCount));

    }

}
