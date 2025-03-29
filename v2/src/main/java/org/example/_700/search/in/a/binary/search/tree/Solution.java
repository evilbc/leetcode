package org.example._700.search.in.a.binary.search.tree;

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode current = root;

        while (current != null) {
            if (current.val == val)
                return current;
            if (current.val > val)
                current = current.left;
            else
                current = current.right;
        }

        return current;
    }
}