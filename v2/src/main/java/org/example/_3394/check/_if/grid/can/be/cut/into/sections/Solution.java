package org.example._3394.check._if.grid.can.be.cut.into.sections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        if (rectangles.length < 3)
            return false;

        List<int[]> merged = mergeHorizontally(rectangles);
        if (merged.size() >= 3)
            return true;

        merged = mergeVertically(rectangles);
        return merged.size() >= 3;
    }

    public List<int[]> mergeHorizontally(int[][] rectangles) {
        Arrays.sort(rectangles, Comparator.comparingInt(o -> o[0]));

        List<int[]> merged = new ArrayList<>();
        int[] current = new int[] { rectangles[0][0], rectangles[0][2] };

        for (int i = 1; i < rectangles.length; i++) {
            int[] interval = rectangles[i];
            int intervalStart = interval[0];
            int prevEnd = current[1];

            if (intervalStart < prevEnd) {
                current[1] = Math.max(current[1], interval[2]);
            } else {
                merged.add(current);
                current = new int[] { interval[0], interval[2] };
            }

        }

        merged.add(current);

        return merged;
    }

    public List<int[]> mergeVertically(int[][] rectangles) {
        Arrays.sort(rectangles, Comparator.comparingInt(o -> o[1]));

        List<int[]> merged = new ArrayList<>();
        int[] current = new int[] { rectangles[0][1], rectangles[0][3] };

        for (int i = 1; i < rectangles.length; i++) {
            int[] interval = rectangles[i];
            int intervalStart = interval[1];
            int prevEnd = current[1];

            if (intervalStart < prevEnd) {
                current[1] = Math.max(current[1], interval[3]);
            } else {
                merged.add(current);
                current = new int[] { interval[1], interval[3] };
            }

        }

        merged.add(current);

        return merged;
    }
}
