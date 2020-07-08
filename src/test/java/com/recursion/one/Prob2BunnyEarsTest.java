package com.recursion.one;

import org.junit.Test;

import static org.junit.Assert.*;

public class Prob2BunnyEarsTest {
    Prob2BunnyEars bunny = new Prob2BunnyEars();

    @Test
    public void bunnyEars() {
       assertEquals(4,  bunny.bunnyEars(2));
    }
}