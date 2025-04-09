package org.example._1372.longest.zigzag.path.in.a.binary.tree;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestZigZag(TreeNode root) {
        return longestZigZag(root, true, 0) - 1;
    }

    private int longestZigZag(TreeNode node, boolean isLeft, int currentCount) {
        if (node == null)
            return currentCount;

        if (isLeft) {
            return Math.max(longestZigZag(node.right, false, currentCount + 1), longestZigZag(node.left, true, 1));
        }

        return Math.max(longestZigZag(node.left, true, currentCount + 1), longestZigZag(node.right, false, 1));
    }
}
