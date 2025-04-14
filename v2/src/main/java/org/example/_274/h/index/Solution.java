package org.example._274.h.index;

import java.util.Arrays;

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int count = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] > count)
                count++;
            else
                break;
        }
        return count;
    }
}