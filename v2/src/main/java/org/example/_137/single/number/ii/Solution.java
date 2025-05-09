package org.example._137.single.number.ii;

class Solution {
    private static final int NUM_BITS = 32;

    public int singleNumber(int[] nums) {
        int result = 0;

        for (int i = 0; i < NUM_BITS; i++) {
            int sum = 0;
            for (int num : nums) {
                sum += (num >> i) & 1;
            }
            result |= (sum % 3) << i;
        }

        return result;
    }
}
