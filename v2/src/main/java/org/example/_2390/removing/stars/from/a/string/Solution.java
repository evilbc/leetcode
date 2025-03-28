package org.example._2390.removing.stars.from.a.string;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public String removeStars(String s) {
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*') {
                deque.removeLast();
            } else {
                deque.addLast(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.removeFirst());
        }
        return sb.toString();
    }
}
