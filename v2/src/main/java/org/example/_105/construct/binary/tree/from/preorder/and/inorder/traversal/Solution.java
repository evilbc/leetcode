package org.example._105.construct.binary.tree.from.preorder.and.inorder.traversal;

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, 0, preorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preorderIndex, int inorderIndex,
            int maxPreorderIndex) {
        if (preorderIndex >= preorder.length || preorderIndex > maxPreorderIndex)
            return null;

        int rootVal = preorder[preorderIndex];
        int countLeft = 0;
        for (int i = inorderIndex; inorder[i] != rootVal; i++) {
            countLeft++;
        }
        TreeNode root = new TreeNode(rootVal);
        if (countLeft > 0)
            root.left = buildTree(preorder, inorder, preorderIndex + 1, inorderIndex, preorderIndex + countLeft);
        root.right = buildTree(preorder, inorder, preorderIndex + 1 + countLeft, inorderIndex + 1 + countLeft,
                maxPreorderIndex);
        return root;
    }
}
