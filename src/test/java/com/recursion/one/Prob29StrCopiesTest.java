package com.recursion.one;

import org.junit.Test;

import static org.junit.Assert.*;

public class Prob29StrCopiesTest {
    Prob29StrCopies copies = new Prob29StrCopies();

    @Test
    public void strCopies() {
        assertFalse(copies.strCopies("catcowcat", "cow", 2));
    }
}