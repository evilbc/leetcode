package org.example._2130.maximum.twin.sum.of.a.linked.list;

class Solution {
    public int pairSum(ListNode head) {
        if (head == null || head.next == null)
            return 0;

        int max = Integer.MIN_VALUE;
        ListNode reverseHead = reverseLatterHalf(head);

        while (reverseHead != null) {
            int sum = head.val + reverseHead.val;
            if (sum > max)
                max = sum;
            head = head.next;
            reverseHead = reverseHead.next;
        }

        return max;
    }

    private ListNode getMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode reverseLatterHalf(ListNode head) {
        ListNode node = getMiddleNode(head);
        ListNode prev = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
}
