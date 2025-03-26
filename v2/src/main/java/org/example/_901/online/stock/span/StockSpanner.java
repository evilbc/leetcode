package org.example._901.online.stock.span;

import java.util.ArrayList;
import java.util.List;

class StockSpanner {
    private List<Integer> stocks;
    private List<Integer> spans;

    public StockSpanner() {
        stocks = new ArrayList<>();
        spans = new ArrayList<>();
    }

    public int next(int price) {
        int count = 1;
        for (int i = stocks.size() - 1; i >= 0; i--) {
            if (stocks.get(i) <= price) {
                int span = spans.get(i);
                count += span;
                i -= (span - 1);
            } else
                break;
        }
        stocks.add(price);
        spans.add(count);
        return count;
    }
}
