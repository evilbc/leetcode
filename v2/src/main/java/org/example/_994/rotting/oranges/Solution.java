package org.example._994.rotting.oranges;

class Solution {
    private static final int IMPOSSIBLE = -1;
    private static final int EMPTY = 0;
    private static final int FRESH = 1;
    private static final int ROTTEN = 2;
    private static final int WILL_ROT = 3;

    public int orangesRotting(int[][] grid) {
        int minutes = 0;
        int prevFresh = grid.length * grid[0].length;
        boolean isFirst = true;
        while (true) {
            boolean madeChange = false;
            int currentFresh = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    int cell = grid[i][j];
                    if (cell != FRESH)
                        continue;

                    boolean hasRottenNeighbor = hasRottenNeighbor(grid, i, j);
                    if (hasRottenNeighbor) {
                        grid[i][j] = WILL_ROT;
                        madeChange = true;
                    } else
                        currentFresh++;
                }
            }
            if (madeChange)
                minutes++;
            if (currentFresh == 0)
                return minutes;
            if (prevFresh == currentFresh)
                return IMPOSSIBLE;
            prevFresh = currentFresh;
            updateRotting(grid);
        }
    }

    private boolean hasRottenNeighbor(int[][] grid, int i, int j) {
        return isRotten(grid, i + 1, j) || isRotten(grid, i - 1, j) || isRotten(grid, i, j + 1) || isRotten(grid, i,
                j - 1);
    }

    private boolean isRotten(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == ROTTEN;
    }

    private void updateRotting(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == WILL_ROT)
                    grid[i][j] = ROTTEN;
            }
        }
    }
}
