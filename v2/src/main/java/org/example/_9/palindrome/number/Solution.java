package org.example._9.palindrome.number;

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        int tenPower = (int) (Math.pow(10, (int) Math.log10(x)));

        while (tenPower > 1) {
            int firstDigit = x / tenPower;
            int lastDigit = x % 10;
            if (firstDigit != lastDigit)
                return false;

            x -= firstDigit * tenPower;
            x /= 10;
            tenPower /= 100;
        }

        return true;
    }
}

