package org.example._112.path.sum;

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSum(root, targetSum, 0);
    }

    private boolean hasPathSum(TreeNode node, int targetSum, int current) {
        if (node == null)
            return false;
        current += node.val;
        if (isLeaf(node))
            return current == targetSum;
        return hasPathSum(node.left, targetSum, current) || hasPathSum(node.right, targetSum, current);
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
