package com.llstq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
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

        int result =0;
        int sign =1;
        int num =0;


        for (int i = 0; i < line.length(); i++) {
            char c = line  .charAt(i);

            if ( Character.isDigit(c )){
                num = 10*num + (int) (c-'0');
            } else if (c  == '+') {
                result += sign*num;
                num =0;
                sign =1;

            } else if (c  == '-') {
                result += sign * num;
                num = 0;
                sign = -1;

            } else if (c  == '*') {
                result += sign*num;
                sign =num; //multiply
                num =0;


            } else if (c  == '/') {
                result += sign*num;
                sign = num; //division
                num =0;


            }else if (c  ==  '(') {
                stack.push(result);
                stack.push(sign);
                sign =1;
                result =0;
            }else if (c  ==  ')') {
                result += sign* num;
                num =0;

                result *= stack.pop();
                result += stack.pop();
            }


        }

        if(num !=0) result += sign* num;


        System.out.println(result);


    }

    public static void main (String [] args) throws IOException {
       /* InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader buffer = new BufferedReader(reader);
        String line = buffer.readLine();
*/
       List<String> line = new ArrayList<>();
       line.add("3+(2*2)");
       line.add(" 3+2");
       line.add("3+5-2");

       int i=0;
        while(i < line.size()){
            calculate(line.get(i++));
          //  line = buffer.readLine();
        }
    }
}
