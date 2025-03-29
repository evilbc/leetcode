package org.example._2352.equal.row.and.column.pairs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Solution {
    public int equalPairs(int[][] grid) {
        Map<ArrayComparator, Integer> arrayCounts = new HashMap<>();

        for (int[] row : grid) {
            ArrayComparator comparator = new ArrayComparator(row);
            int count = arrayCounts.getOrDefault(comparator, 0);
            arrayCounts.put(comparator, count + 1);
        }

        int answer = 0;
        for (int y = 0; y < grid[0].length; y++) {
            int[] column = new int[grid.length];
            for (int x = 0; x < grid.length; x++) {
                column[x] = grid[x][y];
            }
            ArrayComparator comparator = new ArrayComparator(column);
            int count = arrayCounts.getOrDefault(comparator, 0);
            answer += count;
        }
        return answer;
    }

    private static class ArrayComparator {
        private int[] array;

        public ArrayComparator(int[] array) {
            this.array = array;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass())
                return false;
            ArrayComparator that = (ArrayComparator) o;
            return Objects.deepEquals(array, that.array);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(array);
        }
    }

}
