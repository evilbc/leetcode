package org.example._96.unique.binary.search.trees;

class Solution {
    public int numTrees(int n) {
        return numTrees(1, n, new int[n + 1][n + 1]);
    }

    private int numTrees(int min, int max, int[][] cache) {
        if (min >= max)
            return 1;
        if (cache[min][max] != 0)
            return cache[min][max];

        int count = 0;
        for (int i = min; i <= max; i++) {
            count += numTrees(min, i - 1, cache) * numTrees(i + 1, max, cache);
        }
        cache[min][max] = count;
        cache[max][min] = count;
        return count;
    }

}
