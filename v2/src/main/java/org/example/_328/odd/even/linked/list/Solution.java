package org.example._328.odd.even.linked.list;

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;

        ListNode current = head.next;
        ListNode prev = head;
        ListNode prevPrev = head;
        boolean even = true;
        ListNode evenHead = current;

        while (current != null) {
            prev.next = current.next;
            prevPrev = prev;
            prev = current;
            even = !even;
            current = current.next;
        }

        if (even)
            prev.next = evenHead;
        else
            prevPrev.next = evenHead;
        return head;
    }
}
