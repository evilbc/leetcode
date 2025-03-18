package org.example._374.guess.number.higher.or.lower;

class Solution {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (true) {
            int middle = left + (right - left) / 2;
            byte result = (byte) guess(middle);
            if (result == 0)
                return middle;
            if (result == 1)
                left = middle + 1;
            else
                right = middle - 1;
        }
    }

    private int guess(int num) {
        return 0;
    }
}