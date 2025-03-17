package org.example._8.string.to.integer.atoi;

class Solution {
    public int myAtoi(String s) {
        byte sign = 1;
        char[] chars = s.trim()
                .toCharArray();
        if (chars.length == 0)
            return 0;
        if (chars[0] == '-')
            sign = -1;

        int end = findEndIndex(chars);
        int mult = 1;
        int number = 0;
        int start = findStartIndex(chars, end);
        final int MAX_POW = 1_000_000_000;

        for (int i = start; i >= end; i--) {
            int digit = chars[i] - '0';
            int tmp = digit * mult;
            if (mult > MAX_POW || (mult == MAX_POW && digit > 2))  // overflow
                return getRoundedValue(sign);

            number -= tmp; // abs(MIN_VALUE) > abs(MAX_VALUE), so it's easier to subtract rather than add
            if (number > 0)
                return getRoundedValue(sign);
            mult *= 10;
        }
        if (number == Integer.MIN_VALUE && sign > 0)
            return Integer.MAX_VALUE;
        return number * -sign;
    }

    private int getRoundedValue(byte sign) {
        return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
    }

    private int findStartIndex(char[] chars, int end) {
        int start = chars.length - 1;
        for (int i = start; i >= end; i--) {
            if (!Character.isDigit(chars[i]))
                start = i - 1;
        }
        return start;
    }

    private int findEndIndex(char[] chars) {
        int start = 0;
        if (chars[0] == '+' || chars[0] == '-')
            start = 1;
        for (int i = start; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isDigit(c) && c != '0')
                return i;
            if (!Character.isDigit(c))
                return Math.max(0, i - 1);
        }
        return chars.length;
    }
}
