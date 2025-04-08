package org.example._450.delete.node.in.a.bst;

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (root.val == key) {
            TreeNode tmp = new TreeNode(root.val);
            tmp.left = root;
            removeNode(tmp, root);
            return tmp.left;
        }

        SearchResult findResult = findNode(root, key);
        if (findResult == null)
            return root;
        removeNode(findResult.parent(), findResult.node());

        return root;
    }

    private record SearchResult(TreeNode parent, TreeNode node) {
    }

    private SearchResult findNode(TreeNode root, int key) {
        TreeNode current = root;
        TreeNode next;
        while (true) {
            next = current.val > key ? current.left : current.right;
            if (next == null)
                return null;
            if (next.val == key)
                break;
            current = next;
        }
        return new SearchResult(current, next);
    }

    private void removeNode(TreeNode parent, TreeNode toRemove) {
        if (parent.left == toRemove) {
            if (toRemove.right == null) {
                parent.left = toRemove.left;
                return;
            }
            parent.left = toRemove.right;
            TreeNode tmp = toRemove.right;
            while (tmp.left != null) {
                tmp = tmp.left;
            }
            tmp.left = toRemove.left;
        } else {
            if (toRemove.left == null) {
                parent.right = toRemove.right;
                return;
            }
            parent.right = toRemove.left;
            TreeNode tmp = toRemove.left;
            while (tmp.right != null) {
                tmp = tmp.right;
            }
            tmp.right = toRemove.right;
        }
    }
}
