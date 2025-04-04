package org.example._452.minimum.number.of.arrows.to.burst.balloons;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparing(a -> a[1]));
        int arrowCount = 0;
        int prevEnd = points[0][1];

        for (int i = 1; i < points.length; i++) {
            int[] point = points[i];
            int start = point[0];
            int end = point[1];
            if (start > prevEnd) {
                arrowCount++;
                prevEnd = end;
            }
        }
        arrowCount++;

        return arrowCount;
    }
}