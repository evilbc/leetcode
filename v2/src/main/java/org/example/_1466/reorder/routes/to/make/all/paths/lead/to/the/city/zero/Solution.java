package org.example._1466.reorder.routes.to.make.all.paths.lead.to.the.city.zero;

import java.util.*;

class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] connection : connections) {
            graph.get(connection[0])
                    .add(-connection[1]);
            graph.get(connection[1])
                    .add(connection[0]);
        }

        return dfs(graph, new boolean[n], 0);
    }

    private int dfs(List<List<Integer>> graph, boolean[] visited, int current) {
        visited[current] = true;
        int count = 0;
        for (int neighbor : graph.get(current)) {
            if (visited[Math.abs(neighbor)])
                continue;

            count += dfs(graph, visited, Math.abs(neighbor));
            if (neighbor < 0)
                count++;
        }
        return count;
    }
}
