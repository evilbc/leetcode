package org.example._1926.nearest.exit.from.entrance.in.maze;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

class Solution {
    private static final int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    private static final char WALL = '+';

    public static void main(String[] args) {
        new Solution().nearestExit(new char[][] { { '+', '+', '+' }, { '.', '.', '.' }, { '+', '+', '+' } },
                new int[] { 1, 0 });
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        Set<Coordinates> visited = new HashSet<>();
        Coordinates start = new Coordinates(entrance[0], entrance[1]);
        visited.add(start);
        Queue<Coordinates> queue = new LinkedList<>();
        for (int[] direction : DIRECTIONS) {
            queue.offer(new Coordinates(start.x + direction[0], start.y + direction[1]));
        }
        int steps = 1;
        int queuedForSteps = queue.size();

        while (!queue.isEmpty()) {
            if (queuedForSteps == 0) {
                queuedForSteps = queue.size();
                steps++;
            }
            Coordinates current = queue.remove();
            queuedForSteps--;
            if (visited.contains(current) || !current.isInbounds(maze) || maze[current.x][current.y] == WALL)
                continue;
            visited.add(current);
            if (current.isOnEdge(maze))
                return steps;
            for (int[] direction : DIRECTIONS) {
                queue.offer(new Coordinates(current.x + direction[0], current.y + direction[1]));
            }
        }

        return -1;
    }

    private static class Coordinates {
        int x;
        int y;

        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass())
                return false;
            Coordinates that = (Coordinates) o;
            return x == that.x && y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public boolean isInbounds(char[][] maze) {
            return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length;
        }

        public boolean isOnEdge(char[][] maze) {
            return x == 0 || x == maze.length - 1 || y == 0 || y == maze[0].length - 1;
        }
    }
}
