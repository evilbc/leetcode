package org.example._1679.max.number.of.k.sum.pairs;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxOperations(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            int howMany = map.computeIfAbsent(num, key -> 0);
            if (howMany > 0) {
                count++;
                map.put(num, howMany - 1);
            } else {
                map.compute(k - num, (key, value) -> value == null ? 1 : value + 1);
            }
        }

        return count;
    }

}
