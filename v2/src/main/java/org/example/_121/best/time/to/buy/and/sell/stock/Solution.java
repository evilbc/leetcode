package org.example._121.best.time.to.buy.and.sell.stock;

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;

        int globalMin = prices[0];
        int maxProfit = 0;
        for (int price : prices) {
            if (price < globalMin)
                globalMin = price;

            int profit = price - globalMin;
            if (profit > maxProfit)
                maxProfit = profit;
        }
        return maxProfit;
    }
}