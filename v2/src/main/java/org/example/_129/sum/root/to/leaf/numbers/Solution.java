package org.example._129.sum.root.to.leaf.numbers;

class Solution {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    private int sumNumbers(TreeNode node, int current) {
        if (node == null)
            return 0;
        current *= 10;
        current += node.val;
        if (isLeaf(node))
            return current;
        return sumNumbers(node.left, current) + sumNumbers(node.right, current);
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
