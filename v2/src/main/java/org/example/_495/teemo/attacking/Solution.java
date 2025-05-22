package org.example._495.teemo.attacking;

class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int total = 0;
        for (int i = 1; i < timeSeries.length; i++) {
            int prev = timeSeries[i - 1];
            int current = timeSeries[i];

            total += Math.min(duration, current - prev);
        }
        total += duration;
        return total;
    }
}
