package org.example._504.base._7;

class Solution {

    public String convertToBase7(int num) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        if (num < 0) {
            sb.append("-");
            num *= -1;
        }
        int divisor = findMaxPowerOf7(num);

        while (num > 0) {
            int digit = Math.min(6, num / divisor);
            sb.append(digit);
            num -= (divisor * digit);
            divisor /= 7;
        }
        while (divisor > 0) {
            sb.append('0');
            divisor /= 7;
        }

        return sb.toString();
    }

    private int findMaxPowerOf7(int num) {
        int prev = 1;
        int pow = 7;
        while (true) {
            if (pow > num) return prev;
            prev = pow;
            pow *= 7;
        }
    }
}
