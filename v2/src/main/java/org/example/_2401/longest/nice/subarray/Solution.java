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
        List<Integer> seen = new ArrayList<>();
        seen.add(nums[index]);
        int length = 1;

        for (int i = index + 1; i < nums.length; i++) {
            if (!checkNice(seen, nums[i]))
                break;
            seen.add(nums[i]);
            length++;
        }

        return length;
    }

    private boolean checkNice(List<Integer> seen, int num) {
        for (Integer i : seen) {
            if ((i & num) != 0)
                return false;
        }

        return true;
    }
}