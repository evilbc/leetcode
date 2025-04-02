package org.example._139.word._break;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        wordDict.sort(String::compareTo);
        return wordBreak(s, wordDict, 0, new HashSet<>());
    }

    private boolean wordBreak(String s, List<String> wordDict, int startIndex, Set<Integer> seen) {
        if (startIndex == s.length())
            return true;
        if (seen.contains(startIndex))
            return false;
        seen.add(startIndex);
        // don't have to check whole wordDict after adding every char to prefix - words that don't start with earlier part can be rejected form the start
        int leftDict = 0;
        int rightDict = wordDict.size() - 1;

        StringBuilder prefix = new StringBuilder();
        for (int i = startIndex; i < s.length() && leftDict <= rightDict; i++) {
            prefix.append(s.charAt(i));
            String prefixString = prefix.toString();

            for (int l = leftDict; l <= rightDict; l++) {
                if (wordDict.get(l)
                        .equals(prefixString) && wordBreak(s, wordDict, i + 1, seen))
                    return true;
                else if (wordDict.get(l)
                        .startsWith(prefixString))
                    break;
                else
                    leftDict++;
            }
            for (int r = rightDict; r >= leftDict; r--) {
                if (wordDict.get(r)
                        .equals(prefixString) && wordBreak(s, wordDict, i + 1, seen))
                    return true;
                else if (wordDict.get(r)
                        .startsWith(prefixString))
                    break;
                else
                    rightDict--;
            }
        }

        return false;
    }
}