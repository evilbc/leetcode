package org.example._209.minimum.size.subarray.sum;

class Solution {
    public static void main(String[] args) {
        new Solution().minSubArrayLen(7, new int[] { 2, 3, 1, 2, 4, 3 });
    }

    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                int len = right - left + 1;
                minLen = Math.min(minLen, len);
                sum -= nums[left++];
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
