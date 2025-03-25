package org.example._1.two.sum;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                return new int[] { map.get(num), i };
            }

            map.put(target - num, i);
        }

        return new int[] { -1, -1 };
    }
}