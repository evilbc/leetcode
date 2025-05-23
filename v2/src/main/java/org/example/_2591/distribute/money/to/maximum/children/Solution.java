package org.example._2591.distribute.money.to.maximum.children;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    private static final int IMPOSSIBLE = -1;

    public int distMoney(int money, int children) {
        if (children > money) return IMPOSSIBLE;
        if (children == 1) return money == 8 ? 1 : 0;

        int eightCount = 0;
        for (int i = 0; i < children - 2; i++) {
            if (money - 8 >= children - i - 1) {
                eightCount++;
                money -= 8;
            } else return eightCount;
        }
        if (money == 12) return eightCount;
        if (money == 16) eightCount++;
        if (money > 8) eightCount++;
        return eightCount;
    }
}
