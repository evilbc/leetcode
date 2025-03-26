package org.example._88.merge.sorted.array;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0)
            return;

        for (int i = m - 1; i >= 0; i--) {
            nums1[nums1.length - m + i] = nums1[i];
        }

        int resultIndex = 0;
        int nums1Index = nums1.length - m;
        int nums2Index = 0;

        while (nums1Index < nums1.length || nums2Index < nums2.length) {
            if (nums1Index < nums1.length && (nums2Index >= nums2.length || nums1[nums1Index] <= nums2[nums2Index])) {
                nums1[resultIndex] = nums1[nums1Index];
                nums1Index++;
            } else {
                nums1[resultIndex] = nums2[nums2Index];
                nums2Index++;
            }
            resultIndex++;
        }
    }
}