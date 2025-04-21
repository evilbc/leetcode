package org.example._2145.count.the.hidden.sequences;

class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int min = 0;
        int max = 0;
        int current = 0;
        int range = upper - lower;
        for (int diff : differences) {
            current += diff;
            min = Math.min(min, current);
            max = Math.max(max, current);
            if (max - min > range) return 0;
        }
        int arrRange = max - min;
        return range - arrRange + 1;
    }
}
