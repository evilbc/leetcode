package org.example._790.domino.and.tromino.tiling;

class Solution {
    private static final int MOD = 1_000_000_007;

    public int numTilings(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        long[] results = new long[n];
        results[0] = 1;
        results[1] = 2;
        results[2] = 5;
        for (int i = 3; i < n; i++) {
            results[i] = (2 * results[i - 1] + results[i - 3]) % MOD;
        }

        return (int) results[n - 1];
    }
}
