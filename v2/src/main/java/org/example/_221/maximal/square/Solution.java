package org.example._221.maximal.square;

class Solution {
    public int maximalSquare(char[][] matrix) {
        int max = 0;

        int[][] results = new int[matrix.length + 1][matrix[0].length + 1];

        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                if (matrix[i - 1][j - 1] != '1') continue;

                results[i][j] = min(results[i - 1][j - 1], results[i - 1][j], results[i][j - 1]) + 1;
                max = Math.max(max, results[i][j]);
            }
        }

        return max * max;
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
