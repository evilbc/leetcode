package org.example._274.h.index;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        new Solution().hIndex(new int[] { 0, 0, 2 });
    }

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int count = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            int citation = citations[i];
            if (citation > count && citation <= citations.length - i)
                return citation;
            else if (citation > count)
                count++;
            else
                break;
        }
        return count;
    }
}