package com.recursion.one;

public class Prob27NestParen {
    public boolean nestParen(String str) {
        if(str.isEmpty()) return true;
        int n= str.length();
        if(n ==1) return false;

        String leftParenthesis = str.substring(0,1);
        String rightParentesis = str.substring(n-1,n);

        if(leftParenthesis.equals("(") && rightParentesis.equals((")"))){
            String checkStr = str.substring(1,n-1);
            return  nestParen(checkStr);
        }
        return false;
    }


}
