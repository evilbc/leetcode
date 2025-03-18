package org.example._5.longest.palindromic.substring;

class Solution {
    public String longestPalindrome(String s) {
        if (s.isEmpty())
            return "";

        String globalMax = String.valueOf(s.charAt(0));

        for (int i = 0; i < s.length() - globalMax.length(); i++) {
            String localMax = findLongestPalindrome(s, i);
            if (localMax.length() > globalMax.length())
                globalMax = localMax;
        }

        return globalMax;
    }

    private String findLongestPalindrome(final String s, final int startIndex) {
        char c = s.charAt(startIndex);
        String longest = String.valueOf(c);

        for (int i = startIndex + 1; i < s.length(); i++) {
            if (checkPalindrome(s, startIndex, i))
                longest = s.substring(startIndex, i + 1);
        }

        return longest;
    }

    private boolean checkPalindrome(final String s, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            if (s.charAt(startIndex) != s.charAt(endIndex))
                return false;
            startIndex++;
            endIndex--;
        }
        return true;
    }
}