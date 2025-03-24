package org.example._3169.count.days.without.meetings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int countDays(int days, int[][] meetings) {
        List<int[]> intervals = mergeIntervals(meetings);

        int[] prev = intervals.get(0);
        int count = prev[0] - 1; // e.g. if first interval starts at day 2, then there is 1 free

        for (int i = 1; i < intervals.size(); i++) {
            int[] interval = intervals.get(i);
            count += interval[0] - prev[1] - 1;
            prev = interval;
        }

        count += days - prev[1]; // free days at the ends
        return count;
    }

    private List<int[]> mergeIntervals(int[][] intervals) {
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

        return merged;
    }
}
