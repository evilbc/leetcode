package org.example._763.partition.labels;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> charsIndices = new HashMap<>();
        List<int[]> positions = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!charsIndices.containsKey(c)) {
                charsIndices.put(c, positions.size());
                positions.add(new int[] { i, i });
            } else {
                int charIndex = charsIndices.get(c);
                positions.get(charIndex)[1] = i;
            }
        }
        return findMergedIntervalSizes(positions);
    }

    private List<Integer> findMergedIntervalSizes(List<int[]> intervals) {
        List<Integer> mergedIntervalSizes = new ArrayList<>();
        int[] current = new int[] { intervals.getFirst()[0], intervals.getFirst()[1] };

        for (int i = 1; i < intervals.size(); i++) {
            int[] interval = intervals.get(i);
            if (interval[0] < current[1]) {
                current[1] = Math.max(interval[1], current[1]);
            } else {
                mergedIntervalSizes.add(current[1] - current[0] + 1);
                current = interval;
            }
        }
        mergedIntervalSizes.add(current[1] - current[0] + 1);
        return mergedIntervalSizes;
    }
}
