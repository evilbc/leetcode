package org.example._300.longest.increasing.subsequence;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int maxSize = 0;

        for (int num : nums) {
            int index = binarySearch(tails, num, maxSize);
            tails[index] = num;
            if (index == maxSize) maxSize++;
        }

        return maxSize;
    }

    private int binarySearch(int[] tails, int num, int right) {
        int left = 0;
        while (left != right) {
            int mid = (left + right) / 2;
            if (tails[mid] < num) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
