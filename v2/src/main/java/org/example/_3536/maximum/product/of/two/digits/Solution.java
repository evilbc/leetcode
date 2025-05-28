package org.example._3536.maximum.product.of.two.digits;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int maxProduct(int n) {
        int maxDigit = 0;
        int secondMax = 0;
        while (n > 0) {
            int digit = n % 10;
            if (digit > maxDigit) {
                secondMax = maxDigit;
                maxDigit = digit;
            } else if (digit > secondMax) {
                secondMax = digit;
            }
            n /= 10;
        }
        return maxDigit * secondMax;
    }
}