package org.example._82.remove.duplicates.from.sorted.list.ii;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            boolean skip = false;
            while (next != null && next.val == current.val) {
                next = next.next;
                prev.next = next;
                skip = true;
            }
            if (!skip)
                prev = prev.next;
            current = next;
        }

        return dummy.next;
    }
}
