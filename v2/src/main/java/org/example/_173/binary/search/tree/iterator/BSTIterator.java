package org.example._173.binary.search.tree.iterator;

import java.util.Deque;
import java.util.LinkedList;

class BSTIterator {
    private final Deque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new LinkedList<>();
        while (root != null) {
            stack.addLast(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode node = stack.removeLast();
        TreeNode curr = node.right;
        while (curr != null) {
            stack.addLast(curr);
            curr = curr.left;
        }
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
