package org.example._198.house.robber;

class Solution {
    public int rob(int[] nums) {
        int prev = 0;
        int max = 0;

        for (int num : nums) {
            int tmp = Math.max(max, prev + num);
            prev = max;
            max = tmp;
        }

        return max;
    }
}
