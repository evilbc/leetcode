package org.example._56.merge.intervals;

import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> merged = new ArrayList<>();
        int[] prev = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int intervalStart = interval[0];
            int prevEnd = prev[1];

            if (intervalStart <= prevEnd) {
                prev[1] = Math.max(prev[1], interval[1]);
            } else {
                merged.add(prev);
                prev = interval;
            }

        }

        merged.add(prev);

        return merged.toArray(new int[][] {});
    }
}
