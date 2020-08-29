package com.llstq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Stack;

/*
Source: https://leetcode.com/problems/basic-calculator-ii/
Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

Example 1:

Input: "3+2*2"
Output: 7
Example 2:

Input: " 3/2 "
Output: 1
Example 3:

Input: " 3+5 / 2 "
Output: 5
Note:

You may assume that the given expression is always valid.
Do not use the eval built-in library function.
 */
public class BasicCalculator {

    private static void calculate(String line){
        if(line == null) return;

        char [] arr = line.toCharArray();

        if(arr.length == 1) {
            System.out.println(line);
        }


        Stack<Integer> stack = new Stack<>();

        int calc =0;


        for (int i = 0; i < arr.length; i++) {
            if ( Character.isDigit(arr[i]))
                stack.push( arr[i] - '0');

            if (arr[i] == '/') {
                int tmp = (arr[i+1] - '0') /stack.peek();
                stack.pop();
                stack.push(tmp);
                i++;
            }

            if (arr[i] == '*') {
                int tmp = (arr[i+1]- '0')*stack.peek();
                stack.pop();
                stack.push(tmp);
                i++;
            }

            if (arr[i] == '-') {
                int tmp = (arr[i+1]- '0')-stack.peek();
                stack.pop();
                stack.push(tmp);
                i++;
            }

            if (arr[i] == '+') {
                int tmp = (arr[i+1]- '0')+stack.peek();
                stack.pop();
                stack.push(tmp);
                i++;
            }


        }



    }

    public static void main (String [] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader buffer = new BufferedReader(reader);
        String line = buffer.readLine();

        while(!line.isEmpty()){
            calculate(line);
            line = buffer.readLine();
        }
    }
}
