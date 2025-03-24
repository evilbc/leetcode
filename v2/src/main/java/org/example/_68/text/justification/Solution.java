package org.example._68.text.justification;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int startIndex = 0;
        int width = words[0].length(); // with spaces
        int wordWidth = words[0].length();
        List<String> result = new ArrayList<>();
        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            width += word.length() + 1;
            if (width <= maxWidth) {
                wordWidth += word.length();
                continue;
            }

            result.add(buildLine(words, startIndex, i, wordWidth, maxWidth));
            startIndex = i;
            wordWidth = word.length();
            width = word.length();
        }
        result.add(buildLastLine(words, startIndex, maxWidth));
        return result;
    }

    private String buildLine(String[] words, int startIndex, int endIndex, int wordWidth, int maxWidth) {
        int wordCount = endIndex - startIndex;
        if (wordCount == 1) {
            return words[startIndex] + " ".repeat(maxWidth - wordWidth);
        }
        int spaces = maxWidth - wordWidth;
        int spacePerWord = spaces / (wordCount - 1);
        int extraSpaces = spaces - (spacePerWord * (wordCount - 1));
        StringBuilder result = new StringBuilder();
        result.append(words[startIndex]);

        for (int i = startIndex + 1; i < endIndex; i++) {
            String word = words[i];
            result.append(" ".repeat(spacePerWord));
            if (extraSpaces-- > 0)
                result.append(" ");
            result.append(word);
        }

        return result.toString();
    }

    private String buildLastLine(String[] words, int index, int maxWidth) {
        StringBuilder result = new StringBuilder();
        result.append(words[index]);

        for (int i = index + 1; i < words.length; i++) {
            result.append(" ")
                    .append(words[i]);
        }

        return result.append(" ".repeat(maxWidth - result.length()))
                .toString();
    }
}