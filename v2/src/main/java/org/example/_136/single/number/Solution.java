package org.example._136.single.number;

class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;

        for (int num : nums)
            result ^= num;

        return result;
    }
}
