package org.example._2962.count.subarrays.where.max.element.appears.at.least.k.times;

class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = max(nums);
        int maxCount = 0;
        int left = 0;
        int right = 0;
        long result = 0;

        while (right < nums.length || left > right) {
            if (nums[right] == max) maxCount++;

            while (maxCount >= k) {
                if (nums[left++] == max) maxCount--;
                result += nums.length - right;
            }
            right++;
        }
        return result;
    }

    private int max(int[] nums) {
        int max = nums[0];

        for (int num : nums) {
            if (num > max) max = num;
        }

        return max;
    }

}
