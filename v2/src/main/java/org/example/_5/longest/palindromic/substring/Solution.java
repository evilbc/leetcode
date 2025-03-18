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
        String longest = String.valueOf(s.charAt(0));
        int longestLength = 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            letterPositions.computeIfAbsent(c, k -> new ArrayList<>());
            for (Integer startIndex : letterPositions.get(c)) {
                if (i - startIndex < longestLength)
                    break;
                if (checkPalindrome(s, startIndex, i)) {
                    longest = s.substring(startIndex, i + 1);
                    longestLength = longest.length();
                    break;
                }
            }
            letterPositions.get(c)
                    .add(i);
        }

        return longest;
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