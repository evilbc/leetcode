package org.example._334.increasing.triplet.subsequence;

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int lowest = Integer.MAX_VALUE;
        int secondLowest = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= lowest)
                lowest = num;
            else if (num <= secondLowest)
                secondLowest = num;
            else
                return true;
        }
        return false;
    }
}
