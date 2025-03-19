package org.example._114.flatten.binary.tree.to.linked.list;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public void flatten(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        getNodesInOrder(root, queue);

        TreeNode current = queue.poll();
        while (current != null) {
            current.left = null;
            TreeNode next = queue.poll();
            current.right = next;
            current = next;
        }

    }

    private void getNodesInOrder(TreeNode root, Queue<TreeNode> queue) {
        if (root == null)
            return;

        queue.add(root);
        getNodesInOrder(root.left, queue);
        getNodesInOrder(root.right, queue);
    }
}
