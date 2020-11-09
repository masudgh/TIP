package com.hackerrank;

import java.util.Scanner;
import java.util.StringTokenizer;

public class StringToken {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.

        StringTokenizer st1 =
                new StringTokenizer(s, " '.?!,_,@");
        System.out.println(st1.countTokens());
        while (st1.hasMoreTokens()) {
            System.out.println(st1.nextToken());

        }
        scan.close();
    }
}


