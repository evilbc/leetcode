package org.example._1080.insufficient.nodes.in.root.to.leaf.paths;

class Solution {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return sufficientSubset(root, limit, 0) ? null : root;
    }

    private boolean sufficientSubset(TreeNode node, int limit, int current) {
        if (node == null)
            return true;
        current += node.val;
        if (isLeaf(node))
            return current < limit;

        boolean allInsufficient = true;
        if (sufficientSubset(node.left, limit, current))
            node.left = null;
        else
            allInsufficient = false;
        if (sufficientSubset(node.right, limit, current))
            node.right = null;
        else
            allInsufficient = false;

        return allInsufficient;
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
