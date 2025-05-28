package org.example._3560.find.minimum.log.transportation.cost;

class Solution {
    public long minCuttingCost(int n, int m, int k) {
        if (n <= k && m <= k) return 0;

        if (n > k) {
            return findMinCost(n, k);
        }
        return findMinCost(m, k);
    }

    private long findMinCost(int logLength, int maxLength) {
        return (long) (logLength - maxLength) * maxLength;
    }
}