package com.homework;

import org.junit.Test;

import java.sql.Time;

import static org.junit.Assert.*;

public class HW8PowerFunctionTest {
    HW8PowerFunction powerFunction = new HW8PowerFunction();

    @Test
    public void pow() {
        long t1 = System.currentTimeMillis();
        System.out.println( powerFunction.powBrut(2,6) );
        System.out.println( powerFunction.powBrut(2,-5) );
        long t2 = System.currentTimeMillis() ;
        System.out.print("Time used : ");
        System.out.println( t2-t1);

        long t3 = System.currentTimeMillis();
        System.out.println( powerFunction.powOptimize (2,6) );
        System.out.println( powerFunction.powOptimize(2,-5) );
        long t4 = System.currentTimeMillis() ;
        System.out.print("Time used : ");
        System.out.println( t4-t3);
    }
}