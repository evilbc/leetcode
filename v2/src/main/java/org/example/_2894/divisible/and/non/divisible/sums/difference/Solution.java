package org.example._2894.divisible.and.non.divisible.sums.difference;

class Solution {
    public int differenceOfSums(int n, int m) {
        return n * (n + 1) / 2 - n / m * (n / m + 1) * m;
    }
}
