package org.example._1863.sum.of.all.subset.xor.totals;

class Solution {
    public int subsetXORSum(int[] nums) {
        return sumXORSubsets(nums, 0, 0);
    }

    private int sumXORSubsets(int[] nums, int startIndex, int currentXor) {
        int sum = 0;
        sum += currentXor;
        if (startIndex == nums.length)
            return sum;
        for (int i = startIndex; i < nums.length; i++) {
            sum += sumXORSubsets(nums, i + 1, currentXor ^ nums[i]);
        }
        return sum;
    }
}
