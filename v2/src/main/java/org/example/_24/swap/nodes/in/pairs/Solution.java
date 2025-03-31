package org.example._24.swap.nodes.in.pairs;

class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode prev = dummy;
        while (fast != null) {
            slow.next = fast.next;
            fast.next = slow;
            prev.next = fast;
            prev = slow;
            fast = slow.next;
            if (fast != null)
                fast = fast.next;
            slow = slow.next;
        }
        return dummy.next;
    }
}