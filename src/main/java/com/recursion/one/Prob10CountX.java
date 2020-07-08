package com.recursion.one;

public class Prob10CountX {
    public int countX(String str) {
        int count =0;
        if (str.isEmpty()) return 0;
        int n = str.length();

        String rightStr = str.substring(n-1);
        String leftStr = str.substring(0, n-1);

        if (rightStr.equals("x")) count++;
        return countX(leftStr) +count;
    }
}
