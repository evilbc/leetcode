package org.example._216.combination.sum.iii;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum3(k, n, 1, new ArrayList<>(), result);
        return result;
    }

    private void combinationSum3(int remaining, int target, int current, List<Integer> nums,
            List<List<Integer>> result) {
        if (remaining == 0 && target == 0) {
            result.add(new ArrayList<>(nums));
        }
        if (remaining <= 0 || target <= 0)
            return;

        for (int i = current; i <= 9 && target - i >= 0; i++) {
            nums.addLast(i);
            combinationSum3(remaining - 1, target - i, i + 1, nums, result);
            nums.removeLast();
        }
    }
}