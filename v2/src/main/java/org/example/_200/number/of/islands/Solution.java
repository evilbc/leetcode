package org.example._200.number.of.islands;

class Solution {

    public int numIslands(char[][] grid) {
        int islands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0')
                    continue;

                traverseIsland(grid, i, j);
                islands++;
            }
        }

        return islands;
    }

    private void traverseIsland(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0')
            return;

        grid[i][j] = '0';
        traverseIsland(grid, i - 1, j);
        traverseIsland(grid, i + 1, j);
        traverseIsland(grid, i, j - 1);
        traverseIsland(grid, i, j + 1);
    }
}
