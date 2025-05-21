package org.example._3355.zero.array.transformation.i;

class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] diffs = new int[nums.length];
        for (int[] query : queries) {
            diffs[query[0]]++;
            if (query[1] + 1 < nums.length) diffs[query[1] + 1]--;
        }

        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            counter += diffs[i];
            if (counter < nums[i]) return false;
        }
        return true;
    }
}
