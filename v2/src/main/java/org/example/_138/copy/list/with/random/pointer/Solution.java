package org.example._138.copy.list.with.random.pointer;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> nodeMap = new HashMap<>();

        Node dummy = new Node(0);
        Node current = head;
        Node prev = dummy;

        while (current != null) {
            Node copy = nodeMap.computeIfAbsent(current, n -> new Node(n.val));
            if (current.random != null)
                copy.random = nodeMap.computeIfAbsent(current.random, n -> new Node(n.val));

            current = current.next;
            prev.next = copy;
            prev = prev.next;
        }

        return dummy.next;
    }
}