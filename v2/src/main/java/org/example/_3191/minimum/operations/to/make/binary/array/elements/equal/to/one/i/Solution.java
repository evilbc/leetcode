package org.example._3191.minimum.operations.to.make.binary.array.elements.equal.to.one.i;

class Solution {
    public int minOperations(int[] nums) {
        int flips = 0;

        for (int left = 0; left + 2 < nums.length; left++) {
            if (nums[left] == 0) {
                nums[left] = flip(nums[left]);
                nums[left + 1] = flip(nums[left + 1]);
                nums[left + 2] = flip(nums[left + 2]);
                flips++;
            }
        }

        if (nums.length > 1 && nums[nums.length - 1] == 0)
            flips = -1;
        if (nums.length > 2 && nums[nums.length - 2] == 0)
            flips = -1;

        return flips;
    }

    private int flip(int num) {
        return num == 0 ? 1 : 0;
    }
}
