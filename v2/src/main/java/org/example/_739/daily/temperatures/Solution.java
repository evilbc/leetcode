package org.example._739.daily.temperatures;

class Solution {
    private static final int NEVER = 0;

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        for (int i = temperatures.length - 2; i >= 0; i--) {
            result[i] = howManyDaysToWarmer(i, temperatures, result);
        }

        return result;
    }

    private int howManyDaysToWarmer(int index, int[] temperatures, int[] result) {
        int i = index + 1;
        while (i < temperatures.length) {
            if (temperatures[i] > temperatures[index])
                return i - index;

            if (result[i] == NEVER)
                return NEVER;

            i += result[i];
        }
        return NEVER;
    }
}
