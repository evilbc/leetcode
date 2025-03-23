package org.example._289.game.of.life;

class Solution {
    private static final int TO_BE_BORN = -1;
    private static final int DEAD = 0;
    private static final int ALIVE = 1;
    private static final int TO_DIE = 2;

    public static void main(String[] args) {
        new Solution().gameOfLife(new int[][] { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } });
    }

    public void gameOfLife(int[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                int aliveNeighbors = aliveNeighbors(board, row, col);
                if (board[row][col] == ALIVE && (aliveNeighbors > 3 || aliveNeighbors < 2)) {
                    board[row][col] = TO_DIE;
                } else if (board[row][col] == DEAD && aliveNeighbors == 3) {
                    board[row][col] = TO_BE_BORN;
                }
            }
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == TO_BE_BORN) {
                    board[row][col] = ALIVE;
                } else if (board[row][col] == TO_DIE) {
                    board[row][col] = DEAD;
                }
            }
        }
    }

    //  3 - birth, 2-3 stay alive
    private int aliveNeighbors(int[][] board, int row, int col) {
        int alive = 0;

        for (int i = Math.max(0, row - 1); i <= Math.min(board.length - 1, row + 1); i++) {
            for (int j = Math.max(0, col - 1); j <= Math.min(board[i].length - 1, col + 1); j++) {
                if ((board[i][j] == ALIVE || board[i][j] == TO_DIE) && (i != row || j != col)) {
                    alive++;
                }
            }
        }

        return alive;
    }
}
