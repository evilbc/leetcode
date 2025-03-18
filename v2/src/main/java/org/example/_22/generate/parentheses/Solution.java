package org.example._22.generate.parentheses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        if (n < 1)
            return Collections.emptyList();

        List<String> results = new ArrayList<>();
        generate(new StringBuilder(), 0, 0, n, results);
        return results;
    }

    private void generate(StringBuilder sb, int started, int unfinished, int n, List<String> results) {
        if (started == n && unfinished == 0)
            results.add(sb.toString());

        if (started < n)
            generate(unfinished > 0 ? new StringBuilder(sb).append("(") : sb.append("("), started + 1, unfinished + 1,
                    n, results);

        if (unfinished > 0)
            generate(sb.append(")"), started, unfinished - 1, n, results);

    }
}