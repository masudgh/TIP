package com.homework;

import org.junit.Test;

import static org.junit.Assert.*;

public class HW9WildCardTest {
    HW9WildCard wildCard = new HW9WildCard();

    @Test
    public void printWildCardMatch() {
        wildCard.printWildCardMatch("10?");
        wildCard.printWildCardMatch("1?0?");
        wildCard.printWildCardMatch("?");
        wildCard.printWildCardMatch("??0011?");
    }
}