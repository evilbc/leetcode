package org.example._3516.find.closest.person;

class Solution {
    public int findClosest(int x, int y, int z) {
        int d1 = Math.abs(x - z);
        int d2 = Math.abs(y - z);
        if (d1 < d2) return 1;
        if (d2 < d1) return 2;
        return 0;
    }
}