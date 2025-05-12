package org.example._1550.three.consecutive.odds;

class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;

        for (int num : arr) {
            if (isEven(num)) count = 0;
            else if (++count == 3) return true;
        }

        return false;
    }

    private boolean isEven(int num) {
        return num % 2 == 0;
    }

}
