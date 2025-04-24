package org.example._54.spiral.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int upperIndex = 0;
        int lowerIndex = matrix.length - 1;
        int leftIndex = 0;
        int rightIndex = matrix[0].length - 1;

        while (upperIndex <= lowerIndex && leftIndex <= rightIndex) {
            for (int i = leftIndex; i <= rightIndex; i++) {
                result.add(matrix[upperIndex][i]);
            }
            for (int i = ++upperIndex; i <= lowerIndex; i++) {
                result.add(matrix[i][rightIndex]);
            }
            if (upperIndex <= lowerIndex) {
                for (int i = --rightIndex; i >= leftIndex; i--) {
                    result.add(matrix[lowerIndex][i]);
                }
            }
            if (leftIndex <= rightIndex) {
                for (int i = --lowerIndex; i >= upperIndex; i--) {
                    result.add(matrix[i][leftIndex]);
                }
                leftIndex++;
            }
        }

        return result;
    }
}
