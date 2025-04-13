package org.example._714.best.time.to.buy.and.sell.stock.with.transaction.fee;

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int buy = 0;
        int sell = -prices[0];
        for (int price : prices) {
            buy = Math.max(buy, sell + price - fee);
            sell = Math.max(sell, buy - price);
        }
        return buy;
    }
}
