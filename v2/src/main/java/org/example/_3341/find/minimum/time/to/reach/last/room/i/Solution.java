package org.example._3341.find.minimum.time.to.reach.last.room.i;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    private static final int[][] DIRECTIONS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int minTimeToReach(int[][] moveTime) {
        int[][] cache = new int[moveTime.length][moveTime[0].length];
        for (int[] row : cache) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> dijkstra = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        dijkstra.add(new int[]{0, 0, 0});
        while (!dijkstra.isEmpty()) {
            int[] current = dijkstra.remove();
            int time = current[0];
            int x = current[1];
            int y = current[2];

            if (x == moveTime.length - 1 && y == moveTime[0].length - 1) return time;
            if (time >= cache[x][y]) continue;
            cache[x][y] = time;

            for (int[] direction : DIRECTIONS) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (newX >= 0 && newX <= moveTime.length - 1 &&
                        newY >= 0 && newY <= moveTime[0].length - 1 &&
                        cache[newX][newY] == Integer.MAX_VALUE) {
                    dijkstra.add(new int[]{Math.max(time + 1, moveTime[newX][newY] + 1), newX, newY});
                }
            }
        }
        throw new IllegalStateException();
    }
}
