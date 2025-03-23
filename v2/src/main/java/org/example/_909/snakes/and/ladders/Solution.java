package org.example._909.snakes.and.ladders;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    private static final int NORMAL_SPACE = -1;

    public int snakesAndLadders(int[][] board) {
        // pq [0] - rolls, pq [1] - space
        int[] flatBoard = flattenBoard(board);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[] { 0, 1 });
        int[] distances = new int[board.length * board.length];
        Arrays.fill(distances, Integer.MAX_VALUE);

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int rolls = current[0];
            int space = current[1];

            for (int i = 1; i <= 6 && space + i <= distances.length; i++) {
                int newSpace = getBoardSpace(flatBoard, space + i);
                if (rolls + 1 < distances[newSpace - 1]) {
                    distances[newSpace - 1] = rolls + 1;
                    pq.add(new int[] { distances[newSpace - 1], newSpace });
                }
            }

            int tmp = distances[distances.length - 1];
            if (tmp != Integer.MAX_VALUE)
                return tmp;
        }

        return -1;
    }

    private int[] flattenBoard(int[][] board) {
        int[] board1d = new int[board.length * board.length];
        int idx = 0;
        boolean leftToRight = true;
        for (int i = board.length - 1; i >= 0; i--) {
            if (leftToRight) {
                for (int j = 0; j < board.length; j++) {
                    board1d[idx++] = board[i][j];
                }
            } else {
                for (int j = board.length - 1; j >= 0; j--) {
                    board1d[idx++] = board[i][j];
                }
            }

            leftToRight = !leftToRight;
        }
        return board1d;
    }

    private int getBoardSpace(int[] flatBoard, int space) {
        int newSpace = flatBoard[space - 1];
        if (newSpace == NORMAL_SPACE)
            return space;
        return newSpace;
    }

}
