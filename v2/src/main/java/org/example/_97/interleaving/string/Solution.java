package org.example._97.interleaving.string;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        return isInterleave(s1, s2, s3, 0, 0, 0, new HashSet<>());
    }

    private boolean isInterleave(String s1, String s2, String s3, int index1, int index2, int index3, Set<String> visited) {
        for (int i = index3; i < s3.length(); i++) {
            String key = index1 + "," + index2 + "," + i;
            if (visited.contains(key)) return false;
            visited.add(key);
            char c = s3.charAt(index3);
            boolean correctChar1 = index1 < s1.length() && s1.charAt(index1) == c;
            boolean correctChar2 = index2 < s2.length() && s2.charAt(index2) == c;
            if (correctChar1 && !correctChar2) {
                index1++;
                index3++;
            } else if (!correctChar1 && correctChar2) {
                index2++;
                index3++;
            } else if (correctChar1 && correctChar2) {
                return isInterleave(s1, s2, s3, index1 + 1, index2, index3 + 1, visited) || isInterleave(s1, s2, s3, index1, index2 + 1, index3 + 1, visited);
            } else {
                return false;
            }
        }
        return true;
    }
}
