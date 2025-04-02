package org.example._80.remove.duplicates.from.sorted.array.ii;

class Solution {
    public int removeDuplicates(int[] nums) {
        int duplicateCount = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] == nums[i - 1 - duplicateCount] && nums[i] == nums[i - 2 - duplicateCount])
                duplicateCount++;
            nums[i - duplicateCount] = nums[i];
        }
        return nums.length - duplicateCount;
    }
}
