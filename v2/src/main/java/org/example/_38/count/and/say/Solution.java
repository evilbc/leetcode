package org.example._38.count.and.say;

class Solution {
    public String countAndSay(int n) {
        String result = "1";

        for (int i = 1; i < n; i++) {
            result = rle(result);
        }

        return result;
    }

    private String rle(String s) {
        StringBuilder sb = new StringBuilder();
        char prevChar = s.charAt(0);
        int prevCharCount = 1;

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == prevChar) {
                prevCharCount++;
                continue;
            }
            sb.append(prevCharCount).append(prevChar);
            prevChar = c;
            prevCharCount = 1;
        }
        sb.append(prevCharCount).append(prevChar);

        return sb.toString();
    }
}
