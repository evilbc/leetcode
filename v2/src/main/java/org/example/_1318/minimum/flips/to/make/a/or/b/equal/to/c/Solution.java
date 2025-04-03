package org.example._1318.minimum.flips.to.make.a.or.b.equal.to.c;

class Solution {
    private static final int NUM_BITS = 32;

    public int minFlips(int a, int b, int c) {
        int count = 0;

        for (int i = 0; i < NUM_BITS; i++) {
            int bitA = a & (1 << i);
            int bitB = b & (1 << i);
            int bitC = c & (1 << i);

            if (bitC > 0)
                count += howManyFlipsFor1(bitA, bitB);
            else
                count += howManyFlipsFor0(bitA, bitB);
        }

        return count;
    }

    private int howManyFlipsFor1(int bitA, int bitB) {
        return bitA > 0 || bitB > 0 ? 0 : 1;
    }

    private int howManyFlipsFor0(int bitA, int bitB) {
        int count = 0;
        if (bitA > 0)
            count++;
        if (bitB > 0)
            count++;
        return count;
    }
}
