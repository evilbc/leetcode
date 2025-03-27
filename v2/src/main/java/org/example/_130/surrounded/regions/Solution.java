package org.example._130.surrounded.regions;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Solution {
    private static final int[][] DIRECTIONS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve(new char[][] { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
                { 'X', 'O', 'X', 'X' } });
    }

    public void solve(char[][] board) {
        Set<Coordinates> visited = new HashSet<>();

        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 1; j < board[0].length - 1; j++) {
                if (board[i][j] == 'O' && !visited.contains(new Coordinates(i, j))) {
                    Set<Coordinates> group = new HashSet<>();
                    if (canCapture(board, i, j, visited, group)) {
                        group.forEach(coords -> board[coords.x][coords.y] = 'X');
                    }
                }
            }
        }
    }

    private boolean canCapture(char[][] board, int x, int y, Set<Coordinates> visited, Set<Coordinates> group) {
        if (board[x][y] == 'X') {
            return true;
        }
        if (x == 0 || x == board.length - 1 || y == 0 || y == board[0].length - 1) {
            return false;
        }
        Coordinates coordinates = new Coordinates(x, y);
        if (group.contains(coordinates)) {
            return true;
        }
        if (visited.contains(coordinates)) {
            return false;
        }

        group.add(coordinates);
        visited.add(coordinates);
        for (int[] direction : DIRECTIONS) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            if (!canCapture(board, newX, newY, visited, group)) {
                return false;
            }
        }

        return true;
    }

    private static class Coordinates {
        private final int x;
        private final int y;

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
    }
}
