package org.example._995.minimum.number.of.k.consecutive.bit.flips;

class Solution {
    private static final int IMPOSSIBLE = -1;

    public static void main(String[] args) {
        new Solution().minKBitFlips(new int[] { 0, 0, 0, 1, 0, 1, 1, 0 }, 3);
    }

    public int minKBitFlips(int[] nums, int k) {
        int flips = 0;

        for (int left = 0; left + k - 1 < nums.length; left++) {
            if (nums[left] == 0) {
                for (int i = 0; i < k; i++)
                    flip(nums, left + i);

                flips++;
            }
        }

        for (int i = nums.length - 1; i >= 0 && i >= nums.length - k; i--) {
            if (nums[i] == 0) {
                return IMPOSSIBLE;
            }
        }

        return flips;
    }

    private void flip(int[] nums, int index) {
        nums[index] ^= 1;
    }
}
