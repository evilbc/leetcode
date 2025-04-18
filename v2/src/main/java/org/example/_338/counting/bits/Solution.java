package org.example._338.counting.bits;

class Solution {
    public int[] countBits(int n) {
        if (n == 0)
            return new int[] { 0 };
        int[] result = new int[n + 1];
        result[1] = 1;
        int howManyShifts = 1;
        int whenToIncrementShifts = 4;

        for (int i = 2; i <= n; i++) {
            if (i == whenToIncrementShifts) {
                howManyShifts++;
                whenToIncrementShifts *= 2;
            }
            result[i] = result[i ^ (1 << howManyShifts)] + 1;
        }

        return result;
    }
}
