package org.example._2206.divide.array.into.equal.pairs;

class Solution {
    private static final int MAX_NUMBER = 500;

    public boolean divideArray(int[] nums) {
        if (nums.length % 2 != 0)
            return false;

        int[] counts = new int[MAX_NUMBER];

        for (int num : nums) {
            counts[num - 1]++;
        }

        for (int count : counts) {
            if (count % 2 != 0)
                return false;
        }

        return true;
    }
}
