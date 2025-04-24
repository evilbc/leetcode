package org.example._189.rotate.array;

class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        boolean[] visitedIndexes = new boolean[k];
        for (int i = 0; i < k; i++) {
            if (visitedIndexes[i]) continue;
            doRotate(nums, k, i, nums[i], visitedIndexes);
        }
    }

    private void doRotate(int[] nums, int k, int index, int num, boolean[] visitedIndexes) {
        if (index < k) {
            if (visitedIndexes[index]) return;
            visitedIndexes[index] = true;
        }
        int newIndex = (index + k) % nums.length;
        int curr = nums[newIndex];
        nums[newIndex] = num;

        doRotate(nums, k, newIndex, curr, visitedIndexes);
    }
}
