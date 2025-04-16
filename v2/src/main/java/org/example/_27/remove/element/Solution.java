package org.example._27.remove.element;

class Solution {
    public int removeDuplicates(int[] nums) {
        int prev = nums[0];
        int unique = 1;
        int shift = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prev) {
                shift++;
            } else {
                unique++;
                prev = nums[i];
                nums[i - shift] = nums[i];
            }
        }

        return unique;
    }
}