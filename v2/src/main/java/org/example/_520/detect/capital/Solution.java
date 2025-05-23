package org.example._520.detect.capital;

class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1) return true;

        if (Character.isLowerCase(word.charAt(0))) return isLowerCase(word, 1);

        return isLowerCase(word, 1) || isUpperCase(word, 1);
    }

    private boolean isUpperCase(String word, int startIndex) {
        return isBetweenRange(word, startIndex, 'A', 'Z');
    }

    private boolean isLowerCase(String word, int startIndex) {
        return isBetweenRange(word, startIndex, 'a', 'z');
    }

    private boolean isBetweenRange(String word, int startIndex, char start, char end) {
        for (int i = startIndex; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c < start || c > end) return false;
        }
        return true;
    }
}
