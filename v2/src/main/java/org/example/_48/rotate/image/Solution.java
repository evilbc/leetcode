package org.example._48.rotate.image;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        new Solution().rotate(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } });
    }

    public void rotate(int[][] matrix) {
        Set<String> visited = new HashSet<>();
        for (int i = 0; i <= matrix.length / 2; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (visited.contains(i + "," + j))
                    continue;
                swap(matrix, i, j, visited);
            }
        }
    }

    private void swap(int[][] matrix, int row, int col, Set<String> visited) {
        int tmp = matrix[row][col];
        for (int i = 0; i < 4; i++) {
            int prev = tmp;
            int tmpRow = row;
            row = col;
            col = matrix.length - tmpRow - 1;
            tmp = matrix[row][col];
            matrix[row][col] = prev;
            visited.add(row + "," + col);
        }
    }
}
