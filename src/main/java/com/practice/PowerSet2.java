package com.practice;

public class PowerSet2 {

    private static int getPowerFunc(int n, int m){

        if(m<0) return 0;
        else if (m==0) return 1;
        else
          return  n* getPowerFunc(n, m-1);

    }


    private static long getPowerFunc2(int n, int m){

        if(m<0) return 0;
        else if (m==0) return 1;
        else if (m==1) return n;
        else {
            if(m%2==0) return  getPowerFunc(n, m/2)*getPowerFunc(n, m/2);
            else
                return n * getPowerFunc(n, m-1);
        }
    }



    public static void main(String [] args){

        long t1 = System.currentTimeMillis();
        System.out.println( getPowerFunc(3, 13) );
        long t2 = System.currentTimeMillis() ;
        System.out.println("Time [ms] -  : " + (t2-t1));
    }
}
