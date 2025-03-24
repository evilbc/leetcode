package org.example._1749.maximum.absolute.sum.of.any.subarray;

class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int currentMin = 0;
        int currentMax = 0;

        for (int num : nums) {
            currentMin += num;
            currentMax += num;
            min = Math.min(min, currentMin);
            max = Math.max(max, currentMax);
            if (currentMin > 0)
                currentMin = 0;
            if (currentMax < 0)
                currentMax = 0;
        }
        return Math.max(Math.abs(max), Math.abs(min));
    }

}