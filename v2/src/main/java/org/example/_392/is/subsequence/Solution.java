package org.example._392.is.subsequence;

class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty())
            return true;

        int sIndex = 0;

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (c == s.charAt(sIndex) && ++sIndex == s.length()) {
                return true;
            }
        }

        return false;
    }
}
