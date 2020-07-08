package com.recursion.one;

import org.junit.Test;

import static org.junit.Assert.*;

public class Prob27NestParenTest {
    Prob27NestParen paren = new Prob27NestParen();

    @Test
    public void nestParen() {
        assertFalse(paren.nestParen("(((x))"));
    }
}