package com.homework;

import org.junit.Test;

import java.sql.Time;

import static org.junit.Assert.*;

public class HW8PowerFunctionTest {
    HW8PowerFunction powerFunction = new HW8PowerFunction();

    @Test
    public void pow() {
        long t1 = System.currentTimeMillis();
       // System.out.println( powerFunction.powBrut(2,2) );
        System.out.println( powerFunction.powBrut(2,-5) );
        long t2 = System.currentTimeMillis() ;
        System.out.println(t2-t1);
    }
}