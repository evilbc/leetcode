package org.example._860.lemonade.change;

class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fives = 0;
        int tens = 0;

        for (int bill : bills) {
            if (bill == 5) {
                fives++;
            } else if (bill == 10) {
                if (fives-- <= 0)
                    return false;
                tens++;
            } else if (bill == 20) {
                int remaining = 20;
                if (tens > 0) {
                    tens--;
                    remaining = 10;
                }
                while (remaining > 5) {
                    if (fives-- <= 0)
                        return false;
                    remaining -= 5;
                }
            } else {
                throw new RuntimeException("Unexpected bill: " + bill);
            }
        }

        return true;
    }
}
