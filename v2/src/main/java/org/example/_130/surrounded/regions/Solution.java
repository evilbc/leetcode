package org.example._130.surrounded.regions;

class Solution {
    private static final int[][] DIRECTIONS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    private static final char TMP_UNCAPTURABLE = '.';
    private static final char TO_CAPTURE = 'O';
    private static final char CAPTURED = 'X';

    public void solve(char[][] board) {
        rejectBoundaries(board);
        captureAll(board);
        restoreBoundaries(board);
    }

    private void rejectBoundaries(char[][] board) {
        for (int x = 0; x < board.length; x++) {
            if (board[x][0] == TO_CAPTURE) {
                markBoundaryUncapturable(board, x, 0);
            }
            if (board[x][board[0].length - 1] == TO_CAPTURE) {
                markBoundaryUncapturable(board, x, board[0].length - 1);
            }
        }

        for (int y = 0; y < board[0].length; y++) {
            if (board[0][y] == TO_CAPTURE) {
                markBoundaryUncapturable(board, 0, y);
            }
            if (board[board.length - 1][y] == TO_CAPTURE) {
                markBoundaryUncapturable(board, board.length - 1, y);
            }
        }
    }

    private void captureAll(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == TO_CAPTURE) {
                    board[i][j] = CAPTURED;
                }
            }
        }
    }

    private void restoreBoundaries(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == TMP_UNCAPTURABLE) {
                    board[i][j] = TO_CAPTURE;
                }
            }
        }
    }

    private void markBoundaryUncapturable(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != TO_CAPTURE) {
            return;
        }

        board[x][y] = TMP_UNCAPTURABLE;
        for (int[] direction : DIRECTIONS) {
            markBoundaryUncapturable(board, x + direction[0], y + direction[1]);
        }
    }
}
