package org.example._82.remove.duplicates.from.sorted.list.ii;

class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        new Solution().deleteDuplicates(head);
    }

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
