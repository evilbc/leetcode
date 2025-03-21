package org.example._230.kth.smallest.element.in.a.bst;

import java.util.Stack;

class Solution {
    private int count;

    public int kthSmallest(TreeNode root, int k) {
        count = k;

        return traverse(root);
    }

    private int traverse(TreeNode root) {
        if (root == null || count < 0)
            return -1;

        int tmp = traverse(root.left);
        if (tmp != -1)
            return tmp;
        if (--count == 0)
            return root.val;
        tmp = traverse(root.right);
        return tmp;
    }
}