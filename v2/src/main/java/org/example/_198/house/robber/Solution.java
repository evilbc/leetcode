package org.example._198.house.robber;

class Solution {
    public int rob(int[] nums) {
        return rob(nums, 0, new int[nums.length]);
    }

    public int rob(int[] nums, int index, int[] cache) {
        if (index + 1 == nums.length)
            return nums[index];
        if (index + 1 > nums.length)
            return 0;
        if (cache[index] != 0)
            return cache[index];

        if (nums[index] >= nums[index + 1])
            return nums[index] + rob(nums, index + 2, cache);

        int result = Math.max(nums[index] + rob(nums, index + 2, cache), rob(nums, index + 1, cache));
        cache[index] = result;
        return result;
    }
}
