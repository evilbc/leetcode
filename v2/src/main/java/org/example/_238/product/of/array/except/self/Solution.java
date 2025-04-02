package org.example._238.product.of.array.except.self;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int product = 1;
        int zeroCount = 0;
        int zeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num != 0) {
                product *= num;
            } else {
                zeroIndex = i;
                zeroCount++;
                if (zeroCount == 2) {
                    // it'll all be zeros
                    return result;
                }
            }
        }

        if (zeroCount == 1) {
            result[zeroIndex] = product;
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = product / nums[i];
        }
        return result;
    }
}