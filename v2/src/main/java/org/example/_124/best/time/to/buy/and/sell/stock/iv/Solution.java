package org.example._124.best.time.to.buy.and.sell.stock.iv;

import java.util.Arrays;

class Solution {
    public int maxProfit(int k, int[] prices) {
        int[] buys = new int[k + 1];
        Arrays.fill(buys, Integer.MAX_VALUE);
        int[] profits = new int[k + 1];

        for (int price : prices) {
            for (int i = 1; i <= k; i++) {
                buys[i] = Math.min(buys[i], price - profits[i - 1]);
                profits[i] = Math.max(profits[i], price - buys[i]);
            }
        }

        return profits[k];
    }
}
