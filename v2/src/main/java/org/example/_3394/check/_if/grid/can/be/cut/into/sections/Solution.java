package org.example._3394.check._if.grid.can.be.cut.into.sections;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        if (rectangles.length < 3)
            return false;

        int[][] xs = new int[rectangles.length][2];
        int[][] ys = new int[rectangles.length][2];
        for (int i = 0; i < rectangles.length; i++) {
            xs[i][0] = rectangles[i][0];
            xs[i][1] = rectangles[i][2];
            ys[i][0] = rectangles[i][1];
            ys[i][1] = rectangles[i][3];
        }

        return check(xs) || check(ys);
    }

    public boolean check(int[][] directions) {
        Arrays.sort(directions, Comparator.comparingInt(o -> o[0]));

        int count = 0;
        int prevEnd = directions[0][1];

        for (int i = 1; i < directions.length; i++) {
            int[] interval = directions[i];
            int intervalStart = interval[0];

            if (intervalStart >= prevEnd) {
                if (++count >= 2)
                    return true;
                prevEnd = interval[1];
            } else {
                prevEnd = Math.max(prevEnd, interval[1]);
            }

        }

        return false;
    }
}
