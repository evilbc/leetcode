package org.example._1493.longest.subarray.of._1s.after.deleting.one.element;

class Solution {
    public int longestSubarray(int[] nums) {
        int zeroCount = 0;
        int left = 0;
        int right = 0;
        int maxCount = 0;

        while (right < nums.length) {
            if (nums[right] == 0)
                zeroCount++;

            while (zeroCount > 1) {
                if (nums[left] == 0)
                    zeroCount--;
                left++;
            }

            maxCount = Math.max(maxCount, right - left);
            right++;
        }

        return maxCount;
    }

}
