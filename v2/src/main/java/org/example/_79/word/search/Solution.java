package org.example._79.word.search;

class Solution {
    private static final char USED = '.';
    private static final int[][] DIRECTIONS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        char c = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != c) continue;
                board[i][j] = USED;
                if (exist(board, word, 1, i, j)) return true;
                board[i][j] = c;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, String word, int wordIndex, int row, int col) {
        if (wordIndex == word.length()) return true;
        char c = word.charAt(wordIndex);
        for (int[] direction : DIRECTIONS) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (!isInBounds(board, newRow, newCol) || board[newRow][newCol] != c) continue;
            board[newRow][newCol] = USED;
            if (exist(board, word, wordIndex + 1, newRow, newCol)) return true;
            board[newRow][newCol] = c;
        }
        return false;
    }

    private boolean isInBounds(char[][] board, int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
    }
}
