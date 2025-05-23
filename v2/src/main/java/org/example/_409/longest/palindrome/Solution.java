package org.example._409.longest.palindrome;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> charCounts = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCounts.compute(c, (k, v) -> v == null ? 1 : v + 1);
        }
        int longest = 0;
        boolean hasMiddle = false;
        for (Integer count : charCounts.values()) {
            if (count > 1) {
                longest += count % 2 == 0 ? count : count - 1;
            }
            if (!hasMiddle && count % 2 == 1) {
                hasMiddle = true;
                longest++;
            }
        }
        return longest;
    }
}
