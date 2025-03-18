package org.example._1952.three.divisors;

class Solution {
    public boolean isThree(int n) {
        for (int i = 2; i*i <= n; i++)
            if (n % i == 0) {
                return i * i == n;
            }

        return false;
    }
}