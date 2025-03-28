package org.example._1768.merge.strings.alternately;

class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0;
        int j = 0;
        boolean first = true;
        StringBuilder sb = new StringBuilder();
        while (i < word1.length() && j < word2.length()) {
            if (first) {
                sb.append(word1.charAt(i++));
            } else {
                sb.append(word2.charAt(j++));
            }
            first = !first;
        }
        sb.append(word1, i, word1.length())
                .append(word2, j, word2.length());
        return sb.toString();
    }
}
