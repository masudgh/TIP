package com.recursion.one;

public class Prob30StrDist {
    public int strDist(String str, String sub) {
        if (str.isEmpty()) return 0;
        int len = str.length();
        int sublen = sub.length();
        if (sublen > len) return 0;

        String left = str.substring(0, sublen);
        String right = str.substring(len - sublen, len);

        if (left.equals(sub) && right.equals(left)) {
            return len;
        } else if (left.equals(sub)) {
            return strDist(str.substring(0, len - 1), sub);
        }
        return strDist(str.substring(1), sub);
    }

}
