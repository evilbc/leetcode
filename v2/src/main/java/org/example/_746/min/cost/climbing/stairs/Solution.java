package org.example._746.min.cost.climbing.stairs;

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] result = new int[cost.length];
        result[cost.length - 1] = cost[cost.length - 1];
        result[cost.length - 2] = cost[cost.length - 2];

        for (int i = cost.length - 3; i >= 0; i--) {
            result[i] = Math.min(result[i + 1], result[i + 2]) + cost[i];
        }

        return Math.min(result[0], result[1]);
    }
}
