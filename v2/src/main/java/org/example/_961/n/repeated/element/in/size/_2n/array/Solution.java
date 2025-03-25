package org.example._961.n.repeated.element.in.size._2n.array;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num))
                return num;
            set.add(num);
        }
        throw new IllegalStateException();
    }
}
