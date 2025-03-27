package org.example._2780.minimum.index.of.a.valid.split;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int minimumIndex(List<Integer> nums) {
        MajorityElementResult majorityElementResult = majorityElement(nums);
        int majorityElement = majorityElementResult.majorityElement;
        int count = majorityElementResult.count;
        int leftCount = 0;

        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == majorityElement) {
                leftCount++;
            }
            if (2 * leftCount > i + 1 && 2 * (count - leftCount) > nums.size() - i - 1) {
                return i;
            }
        }

        return -1;
    }

    private MajorityElementResult majorityElement(List<Integer> nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        int majorityElement = 0;
        for (int num : nums) {
            Integer count = counts.getOrDefault(num, 0);
            if (++count > nums.size() / 2) {
                majorityElement = num;
            }
            counts.put(num, count);
        }

        return new MajorityElementResult(majorityElement, counts.get(majorityElement));
    }

    private static class MajorityElementResult {
        private int majorityElement;
        private int count;

        public MajorityElementResult(int majorityElement, int count) {
            this.majorityElement = majorityElement;
            this.count = count;
        }
    }
}
