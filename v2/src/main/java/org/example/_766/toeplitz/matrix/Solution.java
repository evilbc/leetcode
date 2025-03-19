package org.example._766.toeplitz.matrix;

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            int nextColumn = i + 1;
            int nextRow = 1;
            while (nextColumn < matrix[0].length && nextRow < matrix.length) {
                if (matrix[nextRow++][nextColumn++] != matrix[0][i])
                    return false;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            int nextColumn = 1;
            int nextRow = i + 1;
            while (nextColumn < matrix[0].length && nextRow < matrix.length) {
                if (matrix[nextRow++][nextColumn++] != matrix[i][0])
                    return false;
            }
        }
        return true;
    }
}