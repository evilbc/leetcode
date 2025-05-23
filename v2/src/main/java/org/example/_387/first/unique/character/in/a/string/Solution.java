package org.example._387.first.unique.character.in.a.string;

class Solution {
    private static final int CHAR_COUNT = 26;
    private static final int NON_UNIQUE = -1;

    public int firstUniqChar(String s) {
        int[] counts = new int[CHAR_COUNT];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (counts[s.charAt(i) - 'a'] == 1) return i;
        }
        return NON_UNIQUE;
    }
}