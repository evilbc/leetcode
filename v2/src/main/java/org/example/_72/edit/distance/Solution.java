package org.example._72.edit.distance;

class Solution {
    public int minDistance(String word1, String word2) {
        return minDistance(word1, word2, 0, 0, new int[word1.length()][word2.length()]);
    }

    private int minDistance(String word1, String word2, int index1, int index2, int[][] cache) {
        if (index1 >= word1.length() && index2 >= word2.length())
            return 0;
        if (index1 >= word1.length())
            return word2.length() - index2; // insert all
        if (index2 >= word2.length())
            return word1.length() - index1; // insert all

        if (word1.charAt(index1) == word2.charAt(index2))
            return minDistance(word1, word2, index1 + 1, index2 + 1, cache);

        if (cache[index1][index2] != 0)
            return cache[index1][index2];

        int insert = 1 + minDistance(word1, word2, index1, index2 + 1, cache);
        int delete = 1 + minDistance(word1, word2, index1 + 1, index2, cache);
        int replace = 1 + minDistance(word1, word2, index1 + 1, index2 + 1, cache);

        int result = min(insert, delete, replace);
        cache[index1][index2] = result;
        return result;
    }

    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
