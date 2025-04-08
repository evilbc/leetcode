package org.example._3396.minimum.number.of.operations.to.make.elements.in.array.distinct;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        int left = 0;
        int index = 0;
        int count = 0;

        while (index < nums.length) {
            int num = nums[index];
            while (seen.contains(num)) {
                count++;
                left = removeFirstThree(nums, left, seen);
                if (left >= nums.length)
                    return count;
                if (left > index) {
                    index = left;
                    num = nums[left];
                }
            }
            seen.add(num);
            index++;
        }

        return count;
    }

    private int removeFirstThree(int[] nums, int startIndex, Set<Integer> seen) {
        int i = startIndex;
        while (i < nums.length && i < startIndex + 3) {
            seen.remove(nums[i++]);
        }
        return i;
    }
}