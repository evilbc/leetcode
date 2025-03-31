package org.example._25.reverse.nodes.in.k.group;

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1)
            return head;

        ListNode dummy = new ListNode(0);
        ListNode prevGroup = dummy;
        ListNode nextGroup = head;
        ListNode current = head;
        ListNode prev = dummy;
        int count = 0;

        while (current != null) {
            if (count == 0 && !isLongEnough(current, k)) {
                prevGroup.next = current;
                break;
            }
            ListNode next = current.next;
            current.next = prev;
            if (++count == k) {
                prevGroup.next = current;
                count = 0;
                nextGroup.next = null;
                prevGroup = nextGroup;
                nextGroup = next;
            }
            prev = current;
            current = next;
        }

        return dummy.next;
    }

    private boolean isLongEnough(ListNode head, int k) {
        while (head != null) {
            if (--k == 0)
                return true;
            head = head.next;
        }
        return false;
    }
}