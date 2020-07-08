package com.recursion.one;

import org.junit.Test;

import static org.junit.Assert.*;

public class Prob6sumDigitsTest {
    Prob6sumDigits sumD = new Prob6sumDigits();

    @Test
    public void sumDigits() {
      assertEquals(13,sumD.sumDigits(49));
    }
}