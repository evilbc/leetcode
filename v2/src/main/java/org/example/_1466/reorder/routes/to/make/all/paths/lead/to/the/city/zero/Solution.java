package org.example._1466.reorder.routes.to.make.all.paths.lead.to.the.city.zero;

import java.util.*;

class Solution {
    public int minReorder(int n, int[][] connections) {
        Map<Integer, Map<Integer, Boolean>> graph = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.add(0);
        for (int[] connection : connections) {
            graph.computeIfAbsent(connection[0], k -> new HashMap<>())
                    .put(connection[1], true);
            graph.computeIfAbsent(connection[1], k -> new HashMap<>())
                    .put(connection[0], false);
        }

        Set<Integer> notConnected = new HashSet<>();
        for (int i = 1; i < n; i++) {
            notConnected.add(i);
        }
        int count = 0;

        while (!notConnected.isEmpty() && !stack.isEmpty()) {
            int current = stack.removeLast();

            for (Map.Entry<Integer, Boolean> entry : graph.computeIfAbsent(current, k -> new HashMap<>())
                    .entrySet()) {
                if (notConnected.contains(entry.getKey())) {
                    notConnected.remove(entry.getKey());
                    stack.add(entry.getKey());
                    if (Boolean.TRUE.equals(entry.getValue())) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
