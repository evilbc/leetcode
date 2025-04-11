package org.example._997.find.the.town.judge;

class Solution {
    private static final int NO_JUDGE = -1;

    public int findJudge(int n, int[][] trust) {
        int[] candidates = new int[n];

        for (int[] pair : trust) {
            int trusts = pair[0];
            int trusted = pair[1];
            candidates[trusts - 1]--;
            candidates[trusted - 1]++;
        }

        for (int i = 0; i < n; i++) {
            if (candidates[i] == n - 1)
                return i + 1;
        }

        return NO_JUDGE;
    }
}
