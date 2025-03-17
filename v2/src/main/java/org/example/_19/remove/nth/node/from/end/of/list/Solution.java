package org.example._19.remove.nth.node.from.end.of.list;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private final int MAX_NUM_OF_NODES = 30;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> nodes = createListOfNodes(head);

        int removeIndex = nodes.size() - n;
        if (removeIndex == 0)
            return nodes.size() > 1 ? nodes.get(1) : null;

        nodes.get(removeIndex - 1).next = removeIndex + 1 == nodes.size() ? null : nodes.get(removeIndex + 1);

        return head;
    }

    private List<ListNode> createListOfNodes(ListNode head) {
        List<ListNode> nodes = new ArrayList<>(MAX_NUM_OF_NODES);

        ListNode current = head;
        while (current != null) {
            nodes.add(current);
            current = current.next;
        }

        return nodes;
    }
}
