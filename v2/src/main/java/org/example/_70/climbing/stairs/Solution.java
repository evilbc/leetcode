package org.example._70.climbing.stairs;

class Solution {
    public int climbStairs(int n) {
        if (n == 1)
            return 1;

        int first = 1;
        int second = 2;
        int tmp = 0;

        for (int i = 2; i < n; i++) {
            tmp = first + second;
            first = second;
            second = tmp;
        }

        return second;
    }
}