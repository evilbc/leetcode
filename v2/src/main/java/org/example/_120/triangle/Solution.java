package org.example._120.triangle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        return minimumTotal(triangle, 0, 0, new HashMap<>());
    }

    private int minimumTotal(List<List<Integer>> triangle, int level, int index, Map<String, Integer> cache) {
        if (level == triangle.size())
            return 0;

        String key = level + "," + index;
        if (cache.containsKey(key))
            return cache.get(key);

        int answer = triangle.get(level)
                .get(index) + Math.min(minimumTotal(triangle, level + 1, index, cache),
                minimumTotal(triangle, level + 1, index + 1, cache));
        cache.put(key, answer);
        return answer;
    }
}
