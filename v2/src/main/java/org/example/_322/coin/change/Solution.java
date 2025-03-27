package org.example._322.coin.change;

import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] howMany = new int[amount + 1];
        Arrays.fill(howMany, Integer.MAX_VALUE);
        howMany[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0 && howMany[i - coin] != Integer.MAX_VALUE) {
                    howMany[i] = Math.min(howMany[i], howMany[i - coin] + 1);
                }
            }
        }

        return howMany[amount] == Integer.MAX_VALUE ? -1 : howMany[amount];
    }
}
