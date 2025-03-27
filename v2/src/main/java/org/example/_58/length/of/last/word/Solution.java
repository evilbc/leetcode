package org.example._58.length.of.last.word;

class Solution {

    public int lengthOfLastWord(String s) {
        if (s.isBlank())
            return 0;
        String[] words = s.trim()
                .split(" ");
        return words[words.length - 1].length();
    }

}
