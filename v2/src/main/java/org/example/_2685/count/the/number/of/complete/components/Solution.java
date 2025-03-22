package org.example._2685.count.the.number.of.complete.components;

import java.util.*;

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> vertexEdges = new HashMap<>();
        for (int i = 0; i < n; i++) {
            vertexEdges.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            vertexEdges.get(edge[0])
                    .add(edge[1]);
            vertexEdges.get(edge[1])
                    .add(edge[0]);
        }
        Map<Integer, Boolean> visited = new HashMap<>();
        int count = 0;

        for (Map.Entry<Integer, List<Integer>> entry : vertexEdges.entrySet()) {
            if (!visited.containsKey(entry.getKey()) && isComplete(entry.getKey(), vertexEdges, visited,
                    new HashSet<>(), entry.getValue()
                            .size() + 1))
                count++;
        }

        return count;
    }

    private boolean isComplete(int vertex, Map<Integer, List<Integer>> vertexEdges, Map<Integer, Boolean> visited,
            Set<Integer> group, int expectedCount) {
        if (visited.containsKey(vertex))
            return visited.get(vertex);

        group.add(vertex);
        List<Integer> list = vertexEdges.get(vertex);
        if (list.size() + 1 != expectedCount) {
            visited.put(vertex, false);
            return false;
        }
        visited.put(vertex, true);

        for (Integer i : list) {
            if (!isComplete(i, vertexEdges, visited, group, expectedCount)) {
                visited.put(vertex, false);
                return false;
            }
        }

        boolean result = group.size() == expectedCount;
        visited.put(vertex, result);
        return result;
    }
}
