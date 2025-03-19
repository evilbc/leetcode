package org.example._1315.sum.of.nodes.with.even.valued.grandparent;

class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        return sumEvenGrandparent(root, false, false);
    }

    private int sumEvenGrandparent(TreeNode root, boolean evenGParent, boolean evenParent) {
        if (root == null)
            return 0;

        boolean isEven = root.val % 2 == 0;
        int value = (evenGParent) ? root.val : 0;

        return value + sumEvenGrandparent(root.left, evenParent, isEven) + sumEvenGrandparent(root.right, evenParent,
                isEven);
    }
}
