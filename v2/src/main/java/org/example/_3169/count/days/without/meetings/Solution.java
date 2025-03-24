package org.example._3169.count.days.without.meetings;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(o -> o[0]));

        int[] prev = meetings[0];
        int count = prev[0] - 1; // e.g. if first interval starts at day 2, then there is 1 free

        for (int i = 1; i < meetings.length; i++) {
            int[] interval = meetings[i];
            int intervalStart = interval[0];
            int prevEnd = prev[1];

            if (intervalStart <= prevEnd) {
                prev[1] = Math.max(prev[1], interval[1]);
            } else {
                count += interval[0] - prev[1] - 1;
                prev = interval;
            }
        }

        count += days - prev[1]; // free days at the ends
        return count;
    }
}
