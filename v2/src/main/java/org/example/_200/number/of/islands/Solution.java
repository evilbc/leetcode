package org.example._200.number.of.islands;

import java.util.*;

class Solution {
    private static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass())
                return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.numIslands(
                new char[][] { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
                        { '0', '0', '0', '0', '0' } });
    }

    public int numIslands(char[][] grid) {
        Set<Pair> visited = new HashSet<>();
        Pair pair = new Pair(0, 0);
        int islands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                pair.x = i;
                pair.y = j;
                if (visited.contains(pair) || grid[i][j] == '0')
                    continue;

                traverseIsland(grid, i, j, visited);
                islands++;
            }
        }

        return islands;
    }

    private void traverseIsland(char[][] grid, int i, int j, Set<Pair> visited) {
        Pair pair = new Pair(i, j);
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited.contains(pair) || grid[i][j] == '0')
            return;

        visited.add(pair);
        traverseIsland(grid, i - 1, j, visited);
        traverseIsland(grid, i + 1, j, visited);
        traverseIsland(grid, i, j - 1, visited);
        traverseIsland(grid, i, j + 1, visited);
    }
}