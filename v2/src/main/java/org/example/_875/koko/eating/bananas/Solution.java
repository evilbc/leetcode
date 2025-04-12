package org.example._875.koko.eating.bananas;

class Solution {
    private static final int MAX_POSSIBLE_SPEED = 1_000_000_000;
    private static final int MIN_POSSIBLE_SPEED = 1;

    public static void main(String[] args) {
        new Solution().minEatingSpeed(new int[] { 805306368, 805306368, 805306368 }, 1000000000);
    }

    public int minEatingSpeed(int[] piles, int h) {
        int left = MIN_POSSIBLE_SPEED;
        int right = MAX_POSSIBLE_SPEED;

        while (left <= right) {
            int mid = (right + left) / 2;
            if (canEatBananasInTime(piles, h, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canEatBananasInTime(int[] piles, int h, int speed) {
        int timeSpent = 0;

        for (int pile : piles) {
            timeSpent += Math.ceilDiv(pile, speed);
            if (timeSpent < 0) // overflow
                return false;
        }

        return timeSpent <= h;
    }
}
