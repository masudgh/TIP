package com.homework;

import com.homework.Recursive.HW11PhoneNumber;
import org.junit.Test;

public class HW11PhoneNumberTest {
    HW11PhoneNumber dp = new HW11PhoneNumber();

    @Test
    public void printNumbers() {
        int [] nums = {2,3 ,5};
        dp.printNumbers(nums);
    }
}