package org.example._3375.minimum.operations.to.make.array.values.equal.to.k;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class Solution {
    private static final int NOT_POSSIBLE = -1;

    public int minOperations(int[] nums, int k) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (num < k)
                return NOT_POSSIBLE;
            if (num == k)
                continue;
            seen.add(num);
        }

        return seen.size();
    }
}