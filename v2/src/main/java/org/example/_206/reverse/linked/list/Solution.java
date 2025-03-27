package org.example._206.reverse.linked.list;

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;

        ListNode prev = head;
        ListNode current = prev.next;
        prev.next = null;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}