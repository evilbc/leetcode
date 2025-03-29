package org.example._1732.find.the.highest.altitude;

class Solution {
    public int largestAltitude(int[] gain) {
        int alt = 0;
        int maxAlt = 0;

        for (int num : gain) {
            alt += num;
            maxAlt = Math.max(maxAlt, alt);
        }

        return maxAlt;
    }

}
