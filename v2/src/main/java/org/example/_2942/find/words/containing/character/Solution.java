package org.example._2942.find.words.containing.character;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> indices = new ArrayList<>();
        String str = String.valueOf(x);
        for (int i = 0; i < words.length; i++) {
            if (words[i].contains(str)) indices.add(i);
        }
        return indices;
    }
}
