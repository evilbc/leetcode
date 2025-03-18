package org.example._22.generate.parentheses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        if (n < 1)
            return Collections.emptyList();

        return generate(new StringBuilder(), 0, 0, n);
    }

    private List<String> generate(StringBuilder sb, int started, int unfinished, int n) {
        if (started == n && unfinished == 0)
            return List.of(sb.toString());

        List<String> results = new ArrayList<>();
        if (started < n)
            results.addAll(generate(new StringBuilder(sb).append("("), started + 1, unfinished + 1, n));

        if (unfinished > 0)
            results.addAll(generate(sb.append(")"), started, unfinished - 1, n));

        return results;
    }
}