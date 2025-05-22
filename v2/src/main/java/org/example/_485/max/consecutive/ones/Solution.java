package org.example._485.max.consecutive.ones;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int consecutive = 0;
        for (int num : nums) {
            if (num != 1) {
                consecutive = 0;
            } else {
                consecutive++;
                max = Math.max(max, consecutive);
            }
        }

        return max;
    }
}
