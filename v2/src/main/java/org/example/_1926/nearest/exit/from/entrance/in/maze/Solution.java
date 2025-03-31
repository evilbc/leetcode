package org.example._1926.nearest.exit.from.entrance.in.maze;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private static final int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    private static final char WALL = '+';

    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> queue = new LinkedList<>();
        for (int[] direction : DIRECTIONS) {
            queue.offer(new int[] { entrance[0] + direction[0], entrance[1] + direction[1] });
        }
        maze[entrance[0]][entrance[1]] = WALL;
        int steps = 1;
        int queuedForSteps = queue.size();

        while (!queue.isEmpty()) {
            if (queuedForSteps == 0) {
                queuedForSteps = queue.size();
                steps++;
            }
            int[] current = queue.remove();
            int x = current[0];
            int y = current[1];
            queuedForSteps--;
            if (!isInbounds(maze, x, y) || maze[x][y] == WALL)
                continue;
            maze[x][y] = WALL;
            if (isOnEdge(maze, x, y))
                return steps;
            for (int[] direction : DIRECTIONS) {
                queue.offer(new int[] { x + direction[0], y + direction[1] });
            }
        }

        return -1;
    }

    public boolean isInbounds(char[][] maze, int x, int y) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length;
    }

    public boolean isOnEdge(char[][] maze, int x, int y) {
        return x == 0 || x == maze.length - 1 || y == 0 || y == maze[0].length - 1;
    }

}
