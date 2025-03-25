package org.example._3.longest.substring.without.repeating.characters;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        StringBuilder builder = new StringBuilder();
        int longest = 0;
        for (char ch : s.toCharArray()) {
            String str = String.valueOf(ch);
            int index = builder.indexOf(str);
            if (index != -1) {
                builder = builder.delete(0, index + 1);
            }
            builder.append(ch);
            if (builder.length() > longest)
                longest = builder.length();
        }
        return longest;
    }
}
