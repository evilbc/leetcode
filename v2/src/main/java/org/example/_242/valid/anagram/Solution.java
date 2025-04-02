package org.example._242.valid.anagram;

class Solution {
    private static final int LETTER_COUNT = 26;

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] characterCounts = new int[LETTER_COUNT];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            characterCounts[c - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (characterCounts[c - 'a']-- == 0)
                return false;
        }
        return true;
    }
}