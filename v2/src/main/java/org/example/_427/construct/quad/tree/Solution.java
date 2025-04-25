package org.example._427.construct.quad.tree;

class Solution {
    public Node construct(int[][] grid) {
        return construct(grid, 0, grid[0].length - 1, 0, grid.length - 1);
    }

    private Node construct(int[][] grid, int left, int right, int top, int bottom) {
        if (isAllSameValue(grid, left, right, top, bottom)) {
            return new Node(grid[top][left] == 1, true);
        }

        int horizontalMid = (left + right) / 2;
        int verticalMid = (top + bottom) / 2;

        Node topLeft = construct(grid, left, horizontalMid, top, verticalMid);
        Node topRight = construct(grid, horizontalMid + 1, right, top, verticalMid);
        Node bottomLeft = construct(grid, left, horizontalMid, verticalMid + 1, bottom);
        Node bottomRight = construct(grid, horizontalMid + 1, right, verticalMid + 1, bottom);
        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    private boolean isAllSameValue(int[][] grid, int left, int right, int top, int bottom) {
        int val = grid[top][left];
        for (int i = top; i <= bottom; i++) {
            for (int j = left; j <= right; j++) {
                if (grid[i][j] != val) return false;
            }
        }
        return true;
    }
}
