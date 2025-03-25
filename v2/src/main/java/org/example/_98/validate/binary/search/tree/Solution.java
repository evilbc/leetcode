package org.example._98.validate.binary.search.tree;

class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValid(TreeNode root, int min, int max) {
        if (root == null)
            return true;
        if (root.val == Integer.MIN_VALUE && root.left != null)
            return false;
        if (root.val == Integer.MAX_VALUE && root.right != null)
            return false;

        return root.val >= min && root.val <= max && isValid(root.left, min, root.val - 1) && isValid(root.right,
                root.val + 1, max);
    }

}
