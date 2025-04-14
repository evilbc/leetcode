package org.example._190.reverse.bits;

class Solution {
    private static final int NUM_BITS = 32;

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < NUM_BITS; i++) {
            int bit = (n >> i) & 1;
            result ^= (bit << NUM_BITS - i - 1);
        }

        return result;
    }
}
