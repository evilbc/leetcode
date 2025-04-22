package org.example._102.binary.tree.level.order.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        addNonNull(root, queue);

        while (!queue.isEmpty()) {
            int levelCount = queue.size();
            List<Integer> level = new ArrayList<>(levelCount);
            for (int i = 0; i < levelCount; i++) {
                TreeNode node = queue.remove();
                level.add(node.val);
                addNonNull(node.left, queue);
                addNonNull(node.right, queue);
            }
            result.add(level);
        }

        return result;
    }

    private void addNonNull(TreeNode node, Queue<TreeNode> queue) {
        if (node != null) queue.add(node);
    }
}
