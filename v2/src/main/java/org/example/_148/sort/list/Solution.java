package org.example._148.sort.list;

class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode middle = findMiddle(head);

        return merge(sortList(head), sortList(middle));
    }

    private ListNode findMiddle(ListNode head) {
        ListNode faster = head.next;
        ListNode slower = head;

        while (faster != null && faster.next != null) {
            faster = faster.next.next;
            slower = slower.next;
        }

        ListNode middle = slower.next;
        slower.next = null;
        return middle;
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode head = new ListNode(0);
        ListNode current = head;

        while (left != null && right != null) {
            if (left.val < right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }

        current.next = left == null ? right : left;

        return head.next;
    }
}