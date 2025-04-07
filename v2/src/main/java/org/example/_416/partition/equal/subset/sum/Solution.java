package org.example._416.partition.equal.subset.sum;

class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = sum(nums);
        if (totalSum % 2 == 1)
            return false;
        totalSum /= 2;

        boolean[] canSum = new boolean[totalSum + 1];

        canSum[0] = true;

        for (int num : nums) {
            for (int i = totalSum; i > 0; i--) {
                if (i >= num) {
                    canSum[i] = canSum[i] || canSum[i - num];
                }
            }
        }
        return canSum[totalSum];
    }

    private int sum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
