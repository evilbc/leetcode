package org.example._75.sort.colors;

class Solution {
    private static final int NUM_COLORS = 3;

    public void sortColors(int[] nums) {
        int[] count = new int[NUM_COLORS];

        for (int num : nums) {
            count[num]++;
        }

        int countIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            while (count[countIndex] == 0) countIndex++;
            nums[i] = countIndex;
            count[countIndex]--;
        }
    }
}
