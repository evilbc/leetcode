package org.example._101.symmetric.tree;

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (right == null)
            return left == null;
        if (left == null)
            return false;

        return left.val == right.val && isSymmetric(right.left, left.right) && isSymmetric(left.left, right.right);
    }
}
