package org.example._2799.count.complete.subarrays.in.an.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    public int countCompleteSubarrays(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();

        int distinctCount = findDistinctNumbersCount(nums);
        int leftIndex = 0;

        int result = 0;
        for (int num : nums) {
            int numCount = counts.getOrDefault(num, 0);
            if (numCount == 0) {
                distinctCount--;
            }
            counts.put(num, numCount + 1);
            while (distinctCount == 0) {
                int leftNum = nums[leftIndex];
                int newCount = counts.put(leftNum, counts.get(leftNum) - 1);
                if (newCount == 0) {
                    distinctCount++;
                }
                leftIndex++;
            }
            result += leftIndex;
        }
        return result;
    }


    private int findDistinctNumbersCount(int[] nums) {
        Set<Integer> distinct = new HashSet<>();
        for (int num : nums) {
            distinct.add(num);
        }
        return distinct.size();
    }
}
