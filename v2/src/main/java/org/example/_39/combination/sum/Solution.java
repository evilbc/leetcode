package org.example._39.combination.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(candidates, target, candidates.length - 1, result, new ArrayList<>());
        return result;
    }

    private void combinationSum(int[] candidates, int target, int rightIndex, List<List<Integer>> result,
            List<Integer> current) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
        }

        for (int i = rightIndex; i >= 0; i--) {
            if (candidates[i] > target)
                continue;

            current.add(candidates[i]);
            combinationSum(candidates, target - candidates[i], i, result, current);
            current.removeLast();
        }
    }
}
