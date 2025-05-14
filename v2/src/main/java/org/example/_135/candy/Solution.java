package org.example._135.candy;

import java.util.Arrays;

class Solution {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);

        ensureMoreCandiesThanLeftNeighbor(ratings, candies);
        ensureMoreCandiesThanRightNeighbor(ratings, candies);

        return sum(candies);
    }

    private void ensureMoreCandiesThanLeftNeighbor(int[] ratings, int[] candies) {
        for (int i = 1; i < candies.length; i++) {
            if (ratings[i] > ratings[i - 1])
                candies[i] = candies[i - 1] + 1;
        }
    }

    private void ensureMoreCandiesThanRightNeighbor(int[] ratings, int[] candies) {
        for (int i = candies.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1])
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
        }
    }

    private int sum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
}
