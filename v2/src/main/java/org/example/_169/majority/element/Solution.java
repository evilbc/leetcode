package org.example._169.majority.element;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            Integer count = counts.getOrDefault(num, 0);
            if (++count > nums.length / 2) {
                return num;
            }
            counts.put(num, count);
        }

        return -1;
    }
}
