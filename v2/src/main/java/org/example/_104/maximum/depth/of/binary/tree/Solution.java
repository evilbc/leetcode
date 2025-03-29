package org.example._104.maximum.depth.of.binary.tree;

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        if (isLeaf(root))
            return 1;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
