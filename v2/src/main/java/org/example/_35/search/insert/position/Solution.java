package org.example._35.search.insert.position;

class Solution {
    public int searchInsert(int[] nums, int target) {
        int insertIndex = 0;
        for (int num : nums) {
            if (num >= target)
                return insertIndex;
            insertIndex++;
        }
        return insertIndex;
    }
}