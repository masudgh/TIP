package com.recursion.one;

import org.junit.Test;

import static org.junit.Assert.*;

public class Prob5TriangleTest {

    Prob5Triangle trang = new Prob5Triangle();

    @Test
    public void triangle() {
       assertEquals(3, trang.triangle(2) );
    }
}