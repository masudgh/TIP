package com.recursion.one;

public class Prob11CountHi {

    public int countHi(String str) {
        int count =0;
        if (str.isEmpty()) return 0;
        int n = str.length();

        if (n<2) return 0;

        String rightStr = str.substring(n-2);
        String leftStr = str.substring(0, n-1);

        if (rightStr.equals("hi")) count++;
        return countHi(leftStr) +count;
    }
}
