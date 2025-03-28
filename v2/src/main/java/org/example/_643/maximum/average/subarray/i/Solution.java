package org.example._643.maximum.average.subarray.i;

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = sum(nums, k);
        int maxSum = sum;
        for (int i = k; i < nums.length; i++) {
            sum -= nums[i - k];
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return 1.0d * maxSum / k;
    }

    private int sum(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
