package org.example._1295.find.numbers.with.even.number.of.digits;

class Solution {
    public int findNumbers(int[] nums) {
        int evenDigitCount = 0;
        for (int num : nums) {
            if (digitCount(num) % 2 == 0) evenDigitCount++;
        }
        return evenDigitCount;
    }

    private int digitCount(int num) {
        int digits = 0;
        while (num > 0) {
            num /= 10;
            digits++;
        }
        return digits;
    }
}
