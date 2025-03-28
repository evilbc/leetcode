package org.example._2503.maximum.number.of.points.from.grid.queries;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    private static final int[][] DIRECTIONS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int[] maxPoints(int[][] grid, int[] queries) {
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            answer[i] = processQuery(grid, queries[i]);
        }
        return answer;
    }

    private int processQuery(int[][] grid, int query) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { 0, 0 });
        int result = 0;
        Set<String> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];
            String key = x + "," + y;
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] >= query || visited.contains(
                    key))
                continue;
            visited.add(key);
            result++;
            for (int[] direction : DIRECTIONS) {
                queue.offer(new int[] { x + direction[0], y + direction[1] });
            }

        }
        return result;
    }
}
