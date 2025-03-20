package org.example._219.contains.duplicate.ii;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0)
            return false;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer prevIndex = map.get(num);
            if (prevIndex != null && i - prevIndex <= k)
                return true;
            map.put(num, i);
        }
        return false;
    }
}
