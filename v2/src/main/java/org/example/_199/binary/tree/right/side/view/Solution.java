package org.example._199.binary.tree.right.side.view;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return Collections.emptyList();

        List<Integer> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            result.add(queue.peek().val);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                addNotNull(node.right, queue);
                addNotNull(node.left, queue);
            }
        }
        return result;
    }

    private void addNotNull(TreeNode node, Queue<TreeNode> queue) {
        if (node != null)
            queue.add(node);
    }
}
