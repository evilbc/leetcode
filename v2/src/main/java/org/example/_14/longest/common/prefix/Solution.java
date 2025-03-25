package org.example._14.longest.common.prefix;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            prefix = longestCommonPrefix(prefix, str);
            if (prefix.isEmpty())
                return prefix;
        }

        return prefix;
    }

    private String longestCommonPrefix(String prefix, String word) {
        for (int i = 0; i < prefix.length() && i < word.length(); i++) {
            if (prefix.charAt(i) != word.charAt(i)) {
                return prefix.substring(0, i);
            }
        }

        return word.length() < prefix.length() ? word : prefix;
    }
}
