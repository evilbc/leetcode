package org.example._73.set.matrix.zeroes;

import java.util.Arrays;

class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstRowZero = false;
        boolean firstColZero = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) continue;

                if (i == 0) firstRowZero = true;
                if (j == 0) firstColZero = true;

                matrix[i][0] = 0;
                matrix[0][j] = 0;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }

        if (firstRowZero) setFirstRowZero(matrix);
        if (firstColZero) setFirstColZero(matrix);
    }

    private void setFirstRowZero(int[][] matrix) {
        Arrays.fill(matrix[0], 0);
    }

    private void setFirstColZero(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][0] = 0;
        }
    }
}
