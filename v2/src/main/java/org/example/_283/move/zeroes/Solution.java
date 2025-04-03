package org.example._283.move.zeroes;

class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0)
            return;

        int position = 0;
        for (int num : nums) {
            if (num != 0)
                nums[position++] = num;
        }

        while (position < nums.length) {
            nums[position++] = 0;
        }
    }
}
