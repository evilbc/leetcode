package org.example._1143.longest.common.subsequence;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] result = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    result[i + 1][j + 1] = result[i][j] + 1;
                } else {
                    result[i + 1][j + 1] = Math.max(result[i][j + 1], result[i + 1][j]);
                }
            }
        }

        return result[text1.length()][text2.length()];
    }
}
