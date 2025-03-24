package org.example._71.simplify.path;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        StringBuilder sb = new StringBuilder();
        List<Integer> partIndices = new LinkedList<>();

        for (String s : split) {
            if (s.equals(".") || s.isEmpty()) {
                continue;
            }
            if (s.equals("..")) {
                if (partIndices.isEmpty())
                    continue;
                sb.delete(partIndices.getLast(), sb.length());
                partIndices.removeLast();
            } else {
                partIndices.add(sb.length());
                sb.append("/")
                        .append(s);
            }
        }

        return sb.isEmpty() ? "/" : sb.toString();
    }
}