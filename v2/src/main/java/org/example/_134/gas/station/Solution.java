package org.example._134.gas.station;

class Solution {
    private static final int IMPOSSIBLE = -1;

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalSurplus = 0;
        int surplus = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            totalSurplus += diff;
            surplus += diff;
            if (surplus < 0) {
                surplus = 0;
                start = i + 1;
            }
        }

        return totalSurplus < 0 ? IMPOSSIBLE : start;
    }
}
