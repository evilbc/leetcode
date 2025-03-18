package org.example._7.reverse.integer;

class Solution {
    public int reverse(int x) {
        int copy = Math.abs(x);
        int reversed = 0;
        while (copy > 0) {
            if (Integer.MAX_VALUE / 10 < reversed)
                return 0;

            reversed = reversed * 10 + copy % 10;
            copy /= 10;
        }

        if (x < 0)
            reversed *= -1;

        return reversed;
    }
}