package org.example._2176.count.equal.and.divisible.pairs.in.an.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int countPairs(int[] nums, int k) {
        int count = 0;
        Map<Integer, List<Integer>> numIndexes = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            List<Integer> indexes = numIndexes.computeIfAbsent(num, x -> new ArrayList<>());
            for (Integer index : indexes) {
                if ((i * index) % k == 0)
                    count++;
            }
            indexes.add(i);
        }
        return count;
    }
}
