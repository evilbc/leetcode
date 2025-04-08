package org.example._1004.max.consecutive.ones.iii;

class Solution {
    public int longestOnes(int[] nums, int k) {
        int zeroCount = 0;
        int left = 0;
        int right = 0;
        int maxCount = 0;

        while (right < nums.length) {
            if (nums[right] == 0)
                zeroCount++;

            while (zeroCount > k) {
                if (nums[left] == 0)
                    zeroCount--;
                left++;
            }

            maxCount = Math.max(maxCount, right - left + 1);
            right++;
        }

        return maxCount;
    }
}
