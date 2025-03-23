package org.example._1976.number.of.ways.to.arrive.at.destination;

import java.util.*;

class Solution {
    private static final int MOD = 1_000_000_007;

    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int v1 = road[0];
            int v2 = road[1];
            int time = road[2];
            graph.get(v1)
                    .add(new int[] { v2, time });
            graph.get(v2)
                    .add(new int[] { v1, time });
        }

        long[] distances = new long[n];
        int[] ways = new int[n];
        Arrays.fill(distances, Long.MAX_VALUE);
        distances[0] = 0;
        ways[0] = 1;

        PriorityQueue<long[]> queue = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        queue.add(new long[] { 0, 0 });

        while (!queue.isEmpty()) {
            long[] current = queue.remove();
            long distance = current[0];
            int node = (int) current[1];

            if (distance > distances[node])
                continue;

            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                int time = neighbor[1];

                if (distances[node] + time < distances[nextNode]) {
                    distances[nextNode] = distances[node] + time;
                    ways[nextNode] = ways[node];
                    queue.add(new long[] { distances[nextNode], nextNode });
                } else if (distances[node] + time == distances[nextNode]) {
                    ways[nextNode] = (ways[nextNode] + ways[node]) % MOD;
                }
            }
        }

        return ways[n - 1];
    }
}
