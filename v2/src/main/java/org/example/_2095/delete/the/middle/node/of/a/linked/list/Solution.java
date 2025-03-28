package org.example._2095.delete.the.middle.node.of.a.linked.list;

class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        prev.next = slow.next;
        return head;
    }
}
