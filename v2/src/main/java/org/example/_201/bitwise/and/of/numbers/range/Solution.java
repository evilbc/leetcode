package org.example._201.bitwise.and.of.numbers.range;

class Solution {
    private static final int NUM_BITS = 32;

    public int rangeBitwiseAnd(int left, int right) {
        int leftBits = numBits(left);
        int rightBits = numBits(right);
        if (leftBits != rightBits)
            return 0;
        int result = right;
        for (int i = leftBits - 1; i >= 0; i--) {
            int leftBit = left & (1 << i);
            int rightBit = right & (1 << i);
            if (leftBit != rightBit) {
                result &= Integer.MAX_VALUE << i;
                return result;
            }
        }
        return result;
    }

    private int numBits(int n) {
        for (int i = NUM_BITS - 1; i >= 0; i--) {
            if ((n & (1 << i)) != 0)
                return i + 1;
        }
        return 0;
    }
}