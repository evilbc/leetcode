package org.example._151.reverse.words.in.a.string;

class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i].isEmpty())
                continue;
            if (!sb.isEmpty())
                sb.append(" ");
            sb.append(words[i]);
        }

        return sb.toString();
    }
}
