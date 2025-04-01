package org.example._64.minimum.path.sum;

class Solution {
    public int minPathSum(int[][] grid) {
        int[][] results = new int[grid.length][grid[0].length];
        minPathSum(grid, 0, 0, results);
        return results[0][0];
    }

    private int minPathSum(int[][] grid, int x, int y, int[][] results) {
        if (results[x][y] != 0) {
            return results[x][y];
        }
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            results[x][y] = grid[x][y];
            return grid[x][y];
        }
        int min = Integer.MAX_VALUE;
        if (x < grid.length - 1) {
            min = minPathSum(grid, x + 1, y, results);
        }
        if (y < grid[0].length - 1) {
            min = Math.min(min, minPathSum(grid, x, y + 1, results));
        }
        min += grid[x][y];
        results[x][y] = min;
        return min;
    }
}
