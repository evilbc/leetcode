package org.example._1448.count.good.nodes.in.binary.tree;

class Solution {
    public int goodNodes(TreeNode root) {
        return goodNodes(root, Integer.MIN_VALUE);
    }

    private int goodNodes(TreeNode root, int max) {
        if (root == null)
            return 0;

        int count = 0;
        if (root.val >= max) {
            max = root.val;
            count++;
        }

        count += goodNodes(root.left, max) + goodNodes(root.right, max);
        return count;
    }
}