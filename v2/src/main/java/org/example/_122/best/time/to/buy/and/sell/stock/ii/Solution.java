package org.example._122.best.time.to.buy.and.sell.stock.ii;

class Solution {
    public int maxProfit(int[] prices) {
        int localMin = prices[0];
        int prev = prices[0];
        int profit = 0;
        int localProfit = 0;
        for (int price : prices) {
            if (price < localMin) {
                localMin = price;
            }
            if (price > localMin) {
                if (localProfit == 0) {
                    localProfit = price - localMin;
                } else if (price > prev) {
                    localProfit += (price - prev);
                } else {
                    profit += localProfit;
                    localProfit = 0;
                    localMin = price;
                }
            }
            prev = price;
        }
        profit += localProfit;
        return profit;
    }
}
