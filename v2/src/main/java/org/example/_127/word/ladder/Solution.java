package org.example._127.word.ladder;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> toVisit = new LinkedList<>();
        toVisit.add(beginWord);
        int ladderLength = 1;
        while (!toVisit.isEmpty()) {
            int howMany = toVisit.size();

            for (int i = 0; i < howMany; i++) {
                String current = toVisit.remove();
                if (current.equals(endWord)) return ladderLength;
                Iterator<String> it = wordList.iterator();
                while (it.hasNext()) {
                    String candidate = it.next();
                    if (isOneDifference(current, candidate)) {
                        it.remove();
                        toVisit.add(candidate);
                    }
                }
            }
            ladderLength++;
        }

        return 0;
    }

    private boolean isOneDifference(String s1, String s2) {
        int diffCount = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i) && diffCount++ > 0) return false;
        }
        return true;
    }
}
