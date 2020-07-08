package com.recursion.one;

import org.junit.Test;

import static org.junit.Assert.*;

public class Prob12ChangeXYTest {
    Prob12ChangeXY change = new Prob12ChangeXY();

    @Test
    public void changeXY() {
        assertEquals("yhiyhiy",change.changeXY("xhixhix"));
    }
}