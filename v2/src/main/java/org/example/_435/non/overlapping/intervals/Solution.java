package org.example._435.non.overlapping.intervals;

import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] < prevEnd) {
                count++;
            } else {
                prevEnd = interval[1];
            }
        }

        return count;
    }
}
