package org.example._1922.count.good.numbers;

class Solution {
    private static final int PRIME_NUMBER_COUNT = 4;
    private static final int EVEN_NUMBER_COUNT = 5;
    private static final int MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        long howManyEven = n / 2;
        long howManyOdd = howManyEven;
        if (n % 2 == 1)
            howManyEven++;

        long result = myPow(EVEN_NUMBER_COUNT, howManyEven) * myPow(PRIME_NUMBER_COUNT, howManyOdd);
        result %= MOD;
        return (int) result;
    }

    private long myPow(long x, long n) {
        if (n == 0)
            return 1;

        return (n % 2 == 0) ? myPow(x * x, n / 2) % MOD : x * myPow(x * x, n / 2) % MOD;
    }
}
