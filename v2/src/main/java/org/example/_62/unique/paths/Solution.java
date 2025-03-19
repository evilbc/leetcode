package org.example._62.unique.paths;

class Solution {

    public int uniquePaths(int m, int n) {
        return countPaths(m, n, new int[m][n]);
    }

    private int countPaths(int i, int j, int[][] cache) {
        if (i <= 0 || j <= 0)
            return 0;

        if (cache[i - 1][j - 1] != 0)
            return cache[i - 1][j - 1];

        if (i == 1 && j == 1)
            return 1;

        int wynik = countPaths(i - 1, j, cache) + countPaths(i, j - 1, cache);
        cache[i - 1][j - 1] = wynik;
        if (cache.length > j && cache[0].length > i) {
            cache[j - 1][i - 1] = wynik;
        }
        return wynik;
    }
}
