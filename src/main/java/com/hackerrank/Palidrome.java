package com.hackerrank;

import java.util.Scanner;

public class Palidrome {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */

        if(A == null){
            System.out.println("No");
        }

        int n = A.length();
        int i=0;
        while(i<n/2){
            if(A.charAt(i) != A.charAt(n-1-i)){
                System.out.println("No");
                return;
            }
            i++;
        }
        System.out.println("yes");

    }

}
