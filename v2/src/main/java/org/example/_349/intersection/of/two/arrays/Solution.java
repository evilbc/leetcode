package org.example._349.intersection.of.two.arrays;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            set2.add(num);
        }
        set1.retainAll(set2);
        return toArray(set1);
    }

    private int[] toArray(Set<Integer> set) {
        int[] arr = new int[set.size()];
        int i = 0;
        for (Integer num : set) {
            arr[i++] = num;
        }
        return arr;
    }
}
