package org.example._23.merge.k.sorted.lists;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        if (lists.length == 1)
            return lists[0];
        Queue<ListNode> remaining = new LinkedList<>();
        for (ListNode list : lists) {
            remaining.offer(list);
        }
        while (true) {
            ListNode first = remaining.poll();
            if (remaining.isEmpty())
                return first;
            remaining.offer(merge(first, remaining.poll()));
        }
    }

    private ListNode merge(ListNode first, ListNode other) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while (first != null && other != null) {
            if (first.val < other.val) {
                ListNode tmp = first;
                first = first.next;
                curr.next = tmp;
            } else {
                ListNode tmp = other;
                other = other.next;
                curr.next = tmp;
            }
            curr = curr.next;
        }
        if (first != null)
            curr.next = first;
        else
            curr.next = other;
        return head.next;
    }
}