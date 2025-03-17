package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean divideArray(int[] nums) {
        if (nums.length % 2 != 0)
            return false;

        Set<Integer> alreadyPaired = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (alreadyPaired.contains(i))
                continue;

            int pair = findPair(nums, i, alreadyPaired);
            if (pair == -1)
                return false;

            alreadyPaired.add(pair);
        }

        return true;
    }

    private int findPair(int[] nums, int index, Set<Integer> toSkip) {
        for (int j = index + 1; j < nums.length; j++) {
            if (toSkip.contains(j))
                continue;

            if (nums[j] == nums[index]) {
                return j;
            }
        }
        return -1;

    }
}
