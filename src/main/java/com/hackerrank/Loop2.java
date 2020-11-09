package com.hackerrank;

import java.util.Scanner;

public class Loop2 {

        public static void main(String []argh){
            Scanner in = new Scanner(System.in);
            int t=in.nextInt();
            for(int i=0;i<t;i++){
                int a = in.nextInt();
                int b = in.nextInt();
                int n = in.nextInt();
                int []arr  = new int [n];
                int powTwo=1;
                int sum =a+b*powTwo;
                arr[0] =sum;
                for(int j=1; j <n; j++){
                    powTwo *=2;
                    sum += b*powTwo;
                    arr[j] =sum;
                }

                for(int j=0; j <n; j++){
                    System.out.print(arr[j]+" ");
                }

                System.out.println();
            }

            in.close();
        }


}
