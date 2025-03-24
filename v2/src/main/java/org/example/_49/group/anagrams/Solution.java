package org.example._49.group.anagrams;

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<LetterHolder, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] letters = countLetters(str);
            map.computeIfAbsent(new LetterHolder(letters), k -> new ArrayList<>())
                    .add(str);
        }

        return new ArrayList<>(map.values());
    }

    private int[] countLetters(String str) {
        int[] letters = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            letters[ch - 'a']++;
        }

        return letters;
    }

    private static class LetterHolder {
        private final int[] letters;

        public LetterHolder(int[] letters) {
            this.letters = letters;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass())
                return false;
            LetterHolder that = (LetterHolder) o;
            return Objects.deepEquals(letters, that.letters);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(letters);
        }
    }
}