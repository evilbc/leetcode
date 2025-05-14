package org.example._52.n.queens.ii;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int totalNQueens(int n) {
        return totalNQueens(n, 0, new HashMap<>());
    }

    private int totalNQueens(int n, int column, Map<Integer, Integer> selected) {
        if (column == n) return 1;

        int solutionCount = 0;
        for (int row = 0; row < n; row++) {
            if (selected.containsKey(row) || !diagonalEmpty(column, row, selected)) continue;
            selected.put(row, column);
            solutionCount += totalNQueens(n, column + 1, selected);
            selected.remove(row);
        }
        return solutionCount;
    }

    private boolean diagonalEmpty(int column, int row, Map<Integer, Integer> selected) {
        for (Map.Entry<Integer, Integer> entry : selected.entrySet()) {
            int entryRow = entry.getKey();
            int entryColumn = entry.getValue();

            if (Math.abs(entryRow - row) == Math.abs(entryColumn - column)) return false;
        }

        return true;
    }
}
