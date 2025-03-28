package org.example._1207.unique.number.of.occurrences;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Set<Integer> counts = new HashSet<>();
        Arrays.sort(arr);
        int count = 1;
        int num = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == num) {
                count++;
            } else {
                if (counts.contains(count))
                    return false;
                counts.add(count);
                num = arr[i];
                count = 1;
            }
        }
        return !counts.contains(count);
    }
}
