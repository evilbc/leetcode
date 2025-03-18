package org.example._2401.longest.nice.subarray;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int longestNiceSubarray(int[] nums) {
        if (nums.length == 0)
            return 0;

        int maxLength = 1;
        for (int i = 0; i < nums.length - maxLength; i++) {
            int length = calculateNiceLength(i, nums);
            if (length > maxLength)
                maxLength = length;
        }
        return maxLength;
    }

    private int calculateNiceLength(int index, int[] nums) {
        int length = 1;

        for (int i = index + 1; i < nums.length; i++) {
            if (!isNice(nums, index, i))
                break;
            length++;
        }

        return length;
    }

    private boolean isNice(int[] nums, int startIndex, int index) {
        for (int i = startIndex; i < index; i++) {
            if ((nums[index] & nums[i]) != 0)
                return false;
        }

        return true;
    }
}