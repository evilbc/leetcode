package org.example._36.valid.sudoku;

import java.util.Arrays;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        return checkRowsAndCols(board) && checkSquares(board);
    }

    private boolean checkRowsAndCols(char[][] board) {
        int[] seenRow = new int[10];
        int[] seenCol = new int[10];
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(seenRow, 0);
            Arrays.fill(seenCol, 0);
            for (int j = 0; j < board[i].length; j++) {
                if (seenRow[board[i][j] - '0']++ > 0)
                    return false;
                if (seenCol[board[j][i] - '0']++ > 0)
                    return false;
            }
        }
        return true;
    }

    private boolean checkSquares(char[][] board) {
        int[] seenSquare = new int[10];
        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board[i].length; j += 3) {
                Arrays.fill(seenSquare, 0);
                if (!checkSquare(board, i, j, seenSquare))
                    return false;
            }
        }
        return true;
    }

    private boolean checkSquare(char[][] board, int x, int y, int[] seen) {
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (seen[board[i][j] - '0']++ > 0)
                    return false;
            }
        }
        return true;
    }
}
