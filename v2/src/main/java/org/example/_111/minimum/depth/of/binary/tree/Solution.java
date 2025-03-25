package org.example._111.minimum.depth.of.binary.tree;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        int depth = 1;
        int currLevelCount = 1;
        int nextLevelCount = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.remove();
            if (current == null)
                continue;

            int childrenCount = childrenCount(current);
            if (childrenCount == 0)
                return depth;
            nextLevelCount += childrenCount;

            queue.add(current.left);
            queue.add(current.right);

            currLevelCount--;
            if (currLevelCount == 0) {
                currLevelCount = nextLevelCount;
                nextLevelCount = 0;
                depth++;
            }
        }

        return depth;
    }

    private int childrenCount(TreeNode node) {
        return checkNonNull(node.left) + checkNonNull(node.right);
    }

    private int checkNonNull(TreeNode node) {
        return node == null ? 0 : 1;
    }
}