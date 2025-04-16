package org.example._290.word.pattern;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> reverseMap = new HashMap<>();

        String[] arr = s.split(" ");
        if (arr.length != pattern.length())
            return false;

        for (int i = 0; i < arr.length; i++) {
            char c = pattern.charAt(i);
            String str = arr[i];
            if (!map.computeIfAbsent(c, k -> str)
                    .equals(str) || reverseMap.computeIfAbsent(str, k -> c) != c)
                return false;
        }

        return true;
    }
}