package org.example._63.unique.paths.ii;

class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        return countPaths(m, n, obstacleGrid, new int[m][n]);
    }

    private int countPaths(int i, int j, int[][] obstacleGrid, int[][] cache) {
        if (i <= 0 || j <= 0 || obstacleGrid[i - 1][j - 1] != 0)
            return 0;

        if (cache[i - 1][j - 1] != 0)
            return cache[i - 1][j - 1];

        if (i == 1 && j == 1)
            return 1;

        int wynik = countPaths(i - 1, j, obstacleGrid, cache) + countPaths(i, j - 1, obstacleGrid, cache);
        cache[i - 1][j - 1] = wynik;
//        if (cache.length > j && cache[0].length > i) {
//            cache[j - 1][i - 1] = wynik;
//        }
        return wynik;
    }
}
