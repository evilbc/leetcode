package org.example._2033.minimum.operations.to.make.a.uni.value.grid;

import java.util.*;

class Solution {
    private static final int NOT_FOUND = -1;

    public int minOperations(int[][] grid, int x) {
        int[] flatGrid = flatten(grid);
        Arrays.sort(flatGrid);
        int midIndex = flatGrid.length / 2;
        int mid = flatGrid[midIndex];
        int count = 0;
        for (int num : flatGrid) {
            int howMany = howManyOperations(mid, num, x);
            if (howMany == NOT_FOUND) {
                return NOT_FOUND;
            }
            count += howMany;
        }

        return count;
    }

    private int[] flatten(int[][] grid) {
        int[] flatGrid = new int[grid.length * grid[0].length];
        int index = 0;
        for (int[] nums : grid) {
            for (int num : nums) {
                flatGrid[index++] = num;
            }
        }
        return flatGrid;
    }

    private int howManyOperations(int mid, int num, int x) {
        int abs = Math.abs(mid - num);
        return abs % x == 0 ? abs / x : NOT_FOUND;
    }
}
