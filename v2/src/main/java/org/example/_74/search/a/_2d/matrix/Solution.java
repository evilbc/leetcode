package org.example._74.search.a._2d.matrix;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            int lastIndex = matrix[i].length - 1;
            if (matrix[i][lastIndex] >= target)
                return searchRow(matrix[i], target);
        }
        return false;
    }

    private boolean searchRow(int[] row, int target) {
        return searchRow(row, 0, row.length - 1, target);
    }

    private boolean searchRow(int[] row, int left, int right, int target) {
        if (left > right)
            return false;

        int middle = left + (right - left) / 2;
        if (row[middle] == target)
            return true;

        if (row[middle] > target)
            return searchRow(row, left, middle - 1, target);

        return searchRow(row, middle + 1, right, target);
    }
}