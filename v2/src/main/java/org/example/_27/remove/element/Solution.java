package org.example._27.remove.element;

class Solution {
    public int removeElement(int[] nums, int val) {
        int removed = 0;

        for (int i = 0; i < nums.length - removed; i++) {
            while (nums[i] == val && i < nums.length - removed) {
                nums[i] = nums[nums.length - removed - 1];
                removed++;
            }
        }

        return nums.length - removed;
    }
}