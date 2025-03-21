package org.example._148.sort.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution {
    public ListNode sortList(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            nodes.add(curr);
            curr = curr.next;
        }
        nodes.sort(Comparator.comparingInt(node -> node.val));

        ListNode newHead = new ListNode(0);
        ListNode prev = newHead;
        for (ListNode node : nodes) {
            prev.next = node;
            prev = node;
        }
        prev.next = null;
        return newHead.next;
    }
}