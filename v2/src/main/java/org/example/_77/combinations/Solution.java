package org.example._77.combinations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if (k > n)
            return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();
        createCombinations(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private void createCombinations(int start, int end, int howMany, List<Integer> current,
            List<List<Integer>> combinations) {
        if (howMany == 0) {
            combinations.add(current);
            return;
        }
        for (int i = start; i <= end && end - i + 1 >= howMany; i++) {
            List<Integer> list = new ArrayList<>(current);
            list.add(i);
            createCombinations(i + 1, end, howMany - 1, list, combinations);
        }
    }
}
