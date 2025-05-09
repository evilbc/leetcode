package org.example._222.count.complete.tree.nodes;

class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = leftHeight(root);
        int rightHeight = rightHeight(root);

        if (leftHeight == rightHeight) return (int) (Math.pow(2, leftHeight) - 1);

        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    private int leftHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            root = root.left;
            height++;
        }
        return height;
    }

    private int rightHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            root = root.right;
            height++;
        }
        return height;
    }
}