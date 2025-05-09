package org.example._46.permutations;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, new boolean[nums.length], result, new ArrayList<>(), 0);
        return result;
    }

    private void permute(int[] nums, boolean[] usedIndices, List<List<Integer>> result, List<Integer> current, int usedCount) {
        if (usedCount == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (usedIndices[i]) continue;
            usedIndices[i] = true;
            current.add(nums[i]);
            permute(nums, usedIndices, result, current, usedCount + 1);
            current.removeLast();
            usedIndices[i] = false;
        }
    }
}
