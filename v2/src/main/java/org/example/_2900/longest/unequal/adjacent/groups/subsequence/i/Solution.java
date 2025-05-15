package org.example._2900.longest.unequal.adjacent.groups.subsequence.i;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> result = new ArrayList<>();
        result.add(words[0]);
        int prev = groups[0];

        for (int i = 1; i < words.length; i++) {
            if (groups[i] != prev) {
                prev = groups[i];
                result.add(words[i]);
            }
        }
        
        return result;
    }
}
