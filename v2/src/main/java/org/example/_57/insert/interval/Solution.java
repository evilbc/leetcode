package org.example._57.insert.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0)
            return new int[][]{newInterval};

        List<int[]> intervalList = new ArrayList<>(Arrays.asList(intervals));
        intervalList.add(newInterval);

        intervalList.sort(Comparator.comparing(a -> a[0]));

        List<int[]> result = new ArrayList<>();
        int[] prev = intervalList.getFirst();

        for (int i = 1; i < intervalList.size(); i++) {
            int[] interval = intervalList.get(i);
            if (interval[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], interval[1]);
            } else {
                result.add(prev);
                prev = interval;
            }
        }
        result.add(prev);

        return result.toArray(new int[][]{});
    }
}
