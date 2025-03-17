package org.example;

public class Solution {
    private final int MAX_NUMBER = 500;

    public boolean divideArray(int[] nums) {
        if (nums.length % 2 != 0)
            return false;

        int[] counts = new int[MAX_NUMBER];

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            counts[num - 1]++;
        }

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] % 2 != 0)
                return false;
        }

        return true;
    }
}
