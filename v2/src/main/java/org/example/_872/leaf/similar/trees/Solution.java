package org.example._872.leaf.similar.trees;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Deque<TreeNode> stack1 = new ArrayDeque<>();
        Deque<TreeNode> stack2 = new ArrayDeque<>();
        stack1.addLast(root1);
        stack2.addLast(root2);

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (stack1.isEmpty() || stack2.isEmpty())
                return false;

            TreeNode node1;
            do {
                node1 = stack1.removeLast();
                addNonNull(node1.right, stack1);
                addNonNull(node1.left, stack1);
            } while (!isLeaf(node1));
            TreeNode node2;
            do {
                node2 = stack2.removeLast();
                addNonNull(node2.right, stack2);
                addNonNull(node2.left, stack2);
            } while (!isLeaf(node2));
            if (node1.val != node2.val)
                return false;
        }

        return true;
    }

    private void addNonNull(TreeNode node, Deque<TreeNode> stack) {
        if (node != null)
            stack.addLast(node);
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
