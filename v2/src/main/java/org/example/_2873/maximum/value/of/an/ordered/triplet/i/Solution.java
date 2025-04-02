package org.example._2873.maximum.value.of.an.ordered.triplet.i;

class Solution {
    public long maximumTripletValue(int[] nums) {
        long max = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    long result = (nums[i] - nums[j]) * (long) nums[k];
                    if (result > max) {
                        max = result;
                    }
                }
            }
        }

        return max;
    }
}
