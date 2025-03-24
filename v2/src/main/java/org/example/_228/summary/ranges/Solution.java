package org.example._228.summary.ranges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0)
            return Collections.emptyList();
        List<String> result = new ArrayList<>();
        int start = nums[0];
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num != prev + 1) {
                result.add(buildRange(start, prev));
                prev = num;
                start = num;
            } else {
                prev = num;
            }
        }
        result.add(buildRange(start, prev));
        return result;
    }

    private String buildRange(int start, int end) {
        if (start == end)
            return String.valueOf(start);
        return start + "->" + end;
    }
}