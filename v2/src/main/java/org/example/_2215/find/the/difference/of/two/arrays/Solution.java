package org.example._2215.find.the.difference.of.two.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<Integer> notIn1 = new ArrayList<>();

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            if (set2.contains(num))
                continue;
            if (set1.contains(num)) {
                set1.remove(num);
            } else {
                notIn1.add(num);
            }
            set2.add(num);
        }
        List<Integer> notIn2 = new ArrayList<>(set1);

        return List.of(notIn2, notIn1);
    }
}
