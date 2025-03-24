package org.example._53.maximum.subarray;

class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int current = 0;

        int i = 0;
        while (i < nums.length) {
            current += nums[i++];
            max = Math.max(max, current);
            if (current < 0)
                current = 0;
        }

        return max;
    }
}