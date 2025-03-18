package org.example._86.partition.list;

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode before = new ListNode(0);
        ListNode beforeHead = before;
        ListNode after = new ListNode(0);
        ListNode afterHead = after;
        while (head != null) {
            if (head.val >= x) {
                after.next = head;
                after = after.next;
            } else {
                before.next = head;
                before = before.next;
            }
            head = head.next;
        }
        after.next = null;
        before.next = afterHead.next;
        return beforeHead.next;
    }
}