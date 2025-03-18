package org.example._5.longest.palindromic.substring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String longestPalindrome(String s) {
        if (s.isEmpty())
            return "";

        Map<Character, List<Integer>> letterPositions = new HashMap<>();
        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            letterPositions.computeIfAbsent(c, k -> new ArrayList<>());
            for (Integer startIndex : letterPositions.get(c)) {
                if (i - startIndex <= right - left)
                    break;
                if (checkPalindrome(s, startIndex, i)) {
                    right = i;
                    left = startIndex;
                    break;
                }
            }
            letterPositions.get(c)
                    .add(i);
        }

        return s.substring(left, right + 1);
    }

    private boolean checkPalindrome(String s, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            if (s.charAt(startIndex) != s.charAt(endIndex))
                return false;
            startIndex++;
            endIndex--;
        }
        return true;
    }
}