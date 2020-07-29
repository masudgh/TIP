package com.dynamic;

public class FibonacciDP {
    public void printFibonacci (int n) {
        System.out.println(findFibonacci(n));
    }

    int findFibonacci(int n){

        int [] cache = new int [n+1];
        for(int i=1; i<= n ; i++){
           if(i==0) cache[i] = 0;
           else if (i <=2) cache [i] =1;
           else{
               cache[i] = cache [i-2]+cache[i-1];
           }
        }

        return cache[n];
    }
}
