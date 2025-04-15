package org.example._13.roman.to.integer;

import java.util.Map;

class Solution {
    private static final Map<Character, Integer> romanNumerals = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D',
            500, 'M', 1000);

    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer value = romanNumerals.get(s.charAt(i));
            if (i + 1 < s.length()) {
                Integer nextValue = romanNumerals.get(s.charAt(i + 1));
                if (nextValue > value) {
                    result += nextValue - value;
                    i++;
                    continue;
                }
            }
            result += value;
        }
        return result;
    }
}
