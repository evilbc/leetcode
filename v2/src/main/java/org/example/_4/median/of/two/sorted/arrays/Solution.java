package org.example._4.median.of.two.sorted.arrays;

class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        boolean isEven = (n + m) % 2 == 0;
        int mid = (n + m) / 2;

        int prev = 0;
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < mid; i++) {
            if (i2 >= nums2.length || (i1 < nums1.length && nums1[i1] < nums2[i2])) {
                prev = nums1[i1];
                i1++;
            } else {
                prev = nums2[i2];
                i2++;
            }
        }

        double res;
        if (i1 >= n)
            res = nums2[i2];
        else if (i2 >= m)
            res = nums1[i1];
        else
            res = Math.min(nums1[i1], nums2[i2]);

        if (isEven)
            res = (res + prev) / 2.0;

        return res;
    }
}
