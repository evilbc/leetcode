package org.example._103.binary.tree.zigzag.level.order.traversal;

import java.util.*;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return Collections.emptyList();

        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of(root.val));
        Deque<TreeNode> queue = new LinkedList<>();
        addNotNull(root.left, queue);
        addNotNull(root.right, queue);
        boolean leftToRight = false;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();
            Deque<TreeNode> nextQueue = new LinkedList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.pollLast();
                level.add(node.val);
                if (leftToRight) {
                    addNotNull(node.left, nextQueue);
                    addNotNull(node.right, nextQueue);
                } else {
                    addNotNull(node.right, nextQueue);
                    addNotNull(node.left, nextQueue);
                }
            }
            result.add(level);
            leftToRight = !leftToRight;
            queue = nextQueue;
        }
        return result;
    }

    private void addNotNull(TreeNode node, Deque<TreeNode> queue) {
        if (node != null)
            queue.offer(node);
    }
}
