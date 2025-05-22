package org.example._404.sum.of.left.leaves;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (isLeaf(node.left)) sum += node.left.val;
            else addNotNull(node.left, queue);
            addNotNull(node.right, queue);
        }
        return sum;
    }

    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

    private void addNotNull(TreeNode node, Queue<TreeNode> queue) {
        if (node != null) queue.add(node);
    }
}
