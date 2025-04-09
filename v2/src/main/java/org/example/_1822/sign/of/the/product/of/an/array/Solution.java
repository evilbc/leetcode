package org.example._1822.sign.of.the.product.of.an.array;

class Solution {
    public int arraySign(int[] nums) {
        boolean isPositive = true;
        for (int num : nums) {
            if (num == 0)
                return 0;
            if (num < 0)
                isPositive = !isPositive;
        }

        return isPositive ? 1 : -1;
    }
}
