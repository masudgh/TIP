package com.homework;

import com.homework.Recursive.HW9WildCard;
import org.junit.Test;

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