package com.recursion.one;

public class Prob12ChangeXY {
    public String changeXY(String str) {
        String y =null;
        if (str.isEmpty()) return "";
        int n = str.length();

        String rightStr = str.substring(n-1);
        String leftStr = str.substring(0, n-1);

        if (rightStr.equals("x")) y ="y";
        else
            y = rightStr;
        return changeXY(leftStr) +y;
    }

}
