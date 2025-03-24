package org.example._122.best.time.to.buy.and.sell.stock.ii;

class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int prev = prices[i - 1];
            int price = prices[i];
            int localProfit = price - prev;
            if (localProfit > 0)
                profit += localProfit;
        }
        return profit;
    }
}
