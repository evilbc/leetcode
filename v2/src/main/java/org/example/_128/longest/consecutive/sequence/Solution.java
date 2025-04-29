package org.example._128.longest.consecutive.sequence;

import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int longest = 1;
        for (int num : nums) {
            if (!set.contains(num)) continue;

            int length = 1;
            int lower = num - 1;
            while (set.contains(lower)) {
                set.remove(lower);
                lower--;
                length++;
            }

            int higher = num + 1;
            while (set.contains(higher)) {
                set.remove(higher);
                higher++;
                length++;
            }

            longest = Math.max(longest, length);
        }
        return longest;
    }
}
