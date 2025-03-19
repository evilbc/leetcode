package org.example._116.populating.next.right.pointers.in.each.node;

class Solution {
    public Node connect(Node root) {
        connect(root, null);
        return root;
    }

    public void connect(Node root, Node next) {
        if (root == null)
            return;


        root.next = next;

        connect(root.left, root.right);
        connect(root.right, (next == null ? null : next.left));
    }}
