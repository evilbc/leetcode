package org.example._71.simplify.path;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        Deque<String> deque = new LinkedList<>();

        for (String s : split) {
            if (s.equals(".") || s.isEmpty()) {
                continue;
            }
            if (!s.equals("..")) {
                deque.addLast(s);
            } else if (!deque.isEmpty()) {
                deque.removeLast();
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append('/')
                    .append(deque.removeFirst());
        }
        return sb.isEmpty() ? "/" : sb.toString();
    }
}