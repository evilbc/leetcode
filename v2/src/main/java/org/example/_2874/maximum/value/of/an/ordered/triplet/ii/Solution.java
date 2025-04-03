package org.example._2874.maximum.value.of.an.ordered.triplet.ii;

class Solution {
    public long maximumTripletValue(int[] nums) {
        long maxTriplet = 0;
        long maxNum = nums[0];
        long minNum = nums[0];
        long maxDiff = 0;
        long maxNegativeDiff = 0;

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num > 0) maxTriplet = Math.max(maxTriplet, maxDiff * num);
            else maxTriplet = Math.max(maxTriplet, maxNegativeDiff * num);
            long diff = maxNum - num;
            long negativeDiff = minNum - num;
            if (num > maxNum) maxNum = num;
            if (num < minNum) minNum = num;
            if (diff > maxDiff) maxDiff = diff;
            if (negativeDiff < maxNegativeDiff) maxNegativeDiff = negativeDiff;

        }

        return maxTriplet;
    }
}
