package org.example._117.populating.next.right.pointers.in.each.node.ii;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public Node connect(Node root) {
        if (root == null)
            return null;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int howManyInLevel = queue.size();
            for (int i = 0; i < howManyInLevel; i++) {
                Node current = queue.remove();
                if (i < howManyInLevel - 1)
                    current.next = queue.peek();
                addNonNull(current.left, queue);
                addNonNull(current.right, queue);
            }
        }

        return root;
    }

    private void addNonNull(Node node, Queue<Node> queue) {
        if (node != null)
            queue.add(node);
    }
}
