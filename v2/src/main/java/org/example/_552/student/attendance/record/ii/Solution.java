package org.example._552.student.attendance.record.ii;

class Solution {
    private static final int MODULO = 1_000_000_007;
    private int[][] cache; // [] - length [] - absences and lates
    //(0 - 0a0l, 1 - 0a1l 2- 0a2l 3 - 1a0l 4 -1a1l, 5 1a2l)

    public int checkRecord(int n) {
        cache = new int[n][6];
        return checkRecord(n, 0, 0);
    }

    private int checkRecord(int length, int absences, int lates) {
        if (length == 0) {
            return 1;
        }
        int cacheIndex = 3 * absences + lates;
        if (cache[length - 1][cacheIndex] != 0)
            return cache[length - 1][cacheIndex];

        int count = 0;
        if (absences == 0) {
            count += checkRecord(length - 1, 1, 0);
            count %= MODULO;
        }

        if (lates < 2) {
            count += checkRecord(length - 1, absences, lates + 1);
            count %= MODULO;
        }

        count += checkRecord(length - 1, absences, 0);
        count %= MODULO;

        cache[length - 1][cacheIndex] = count;
        return count;
    }
}
