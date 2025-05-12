package org.example._2094.finding._3.digit.even.numbers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private static final int NUM_DIGITS = 3;

    public int[] findEvenNumbers(int[] digits) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : digits) {
            map.compute(num, (k, v) -> v == null ? 1 : v + 1);
        }
        generateNumbers(result, map, new ArrayList<>());
        return result.stream().mapToInt(i -> i).sorted().toArray();
    }

    private void generateNumbers(List<Integer> result, Map<Integer, Integer> digits, List<Integer> current) {
        if (current.size() == NUM_DIGITS) {
            result.add(toInt(current));
            return;
        }

        for (Map.Entry<Integer, Integer> entry : digits.entrySet()) {
            if (entry.getValue() == 0 || (current.isEmpty() && entry.getKey() == 0) ||
                    (current.size() == NUM_DIGITS - 1 && entry.getKey() % 2 == 1)) continue;

            current.addLast(entry.getKey());
            entry.setValue(entry.getValue() - 1);
            generateNumbers(result, digits, current);
            current.removeLast();
            entry.setValue(entry.getValue() + 1);
        }
    }

    private int toInt(List<Integer> current) {
        int num = 0;
        int mult = 100;
        for (Integer i : current) {
            num += mult * i;
            mult /= 10;
        }
        return num;
    }
}
