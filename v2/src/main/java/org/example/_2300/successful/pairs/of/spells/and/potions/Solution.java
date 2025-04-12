package org.example._2300.successful.pairs.of.spells.and.potions;

import java.util.Arrays;

class Solution {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] result = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            result[i] = countSuccessfulPairs(spells[i], potions, success);
        }

        return result;
    }

    private int countSuccessfulPairs(int spell, int[] potions, long success) {
        long min = Math.ceilDiv(success, spell);
        int left = 0;
        int right = potions.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (potions[mid] < min) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return potions.length - left;
    }
}
