package org.example._2918.minimum.equal.sum.of.two.arrays.after.replacing.zeros;

class Solution {
    private static final int IMPOSSIBLE = -1;

    public long minSum(int[] nums1, int[] nums2) {
        ArrInfo info1 = findArrInfo(nums1);
        long minSum1 = info1.minSum;
        ArrInfo info2 = findArrInfo(nums2);
        long minSum2 = info2.minSum;

        if (minSum1 == minSum2) return minSum1;

        if (minSum1 > minSum2) {
            if (!info2.hasZero) return IMPOSSIBLE;
            return minSum1;
        }

        if (!info1.hasZero) return IMPOSSIBLE;
        return minSum2;
    }

    private ArrInfo findArrInfo(int[] arr) {
        boolean hasZero = false;
        long minSum = 0;
        for (int num : arr) {
            if (num == 0) {
                hasZero = true;
                minSum += 1;
            } else {
                minSum += num;
            }
        }
        return new ArrInfo(hasZero, minSum);
    }

    private record ArrInfo(boolean hasZero, long minSum) {
    }
}
