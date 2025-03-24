package org.example._92.reverse.linked.list.ii;

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right)
            return head;
        int i = 1;
        ListNode current = head;
        ListNode prev = null;
        while (i < left) {
            prev = current;
            current = current.next;
            i++;
        }
        ListNode last = prev;
        ListNode start = current;
        ListNode next = current.next;
        ListNode tmp = null;
        while (i < right) {
            tmp = next.next;
            next.next = current;
            current = next;
            next = tmp;
            i++;
        }
        if (last != null) {
            last.next = current;
        } else {
            head = current;
        }
        start.next = tmp;
        return head;
    }
}
