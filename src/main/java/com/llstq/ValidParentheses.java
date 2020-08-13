package com.llstq;

import java.util.Stack;

/*

Write a function that checks if the given input string has matching opening and closing
parentheses. Valid parantheses are: ‘(‘, ‘)’, ‘{‘, ‘}’, ‘[‘, ‘]’
Test cases:
1. Input: “( ( 1 + 2 ) * 3 )”, Output: True
2. Input: “( { 1 + 2 ) * 3 )”, Output: False
3. Input: “( ( (1 + 2) * 3 ))”, Output: True
4. Input: “{([])}”, Output: True
5. Input: “} ( 1 * 2) + 3 * ( 5 - 6)”: False

 */
public class ValidParentheses {

    private static boolean isValidParentheses(String str) {
        if (str == null) return false;
        if (str.isEmpty()) return false;

        char[] arr = str.toCharArray();

        Stack<Character> stack = new Stack<>();
        stack.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == '(' || arr[i] == '{' || arr[i] == '[')
                stack.push(arr[i]);

            if (arr[i] == ')') {
                if (stack.peek() == '(') stack.pop();
            }

            if (arr[i] == '}') {
                if (stack.peek() == '{') stack.pop();
            }

            if (arr[i] == ']') {
                if (stack.peek() == '[') stack.pop();
            }
        }

        return stack.isEmpty();
    }

    //main
    public static void main(String [] args){
        String str1 = "( ( 1 + 2 ) * 3 )";
        boolean flag1 = isValidParentheses(str1);
        System.out.println(flag1);

        String str2 = "( { 1 + 2 ) * 3 )";
        boolean flag2 = isValidParentheses(str2);
        System.out.println(flag2);

        String str3 = "( ( (1 + 2) * 3 ))";
        boolean flag3 = isValidParentheses(str3);
        System.out.println(flag3);

        String str4 = "{([])}";
        boolean flag4 = isValidParentheses(str4);
        System.out.println(flag4);

        String str5 = "} ( 1 * 2) + 3 * ( 5 - 6)";
        boolean flag5 = isValidParentheses(str5);
        System.out.println(flag5);
    }
}
