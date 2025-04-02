package org.example._205.isomorphic.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mappings = new HashMap<>();
        Set<Character> mappedTo = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (mappings.get(sChar) == null) {
                mappings.put(sChar, tChar);
                if (mappedTo.contains(tChar))
                    return false;
                mappedTo.add(tChar);
            } else if (mappings.get(sChar) != tChar)
                return false;
        }

        return true;
    }
}