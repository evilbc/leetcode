package org.example._234.palindrome.linked.list;

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) return true;
        ListNode mid = getMiddle(head);
        ListNode end = reverse(mid);
        return areSame(head, end);
    }

    private ListNode getMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        if (fast == null) {
            return slow;
        }
        return slow.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    private boolean areSame(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }

        return l1 == null && l2 == null;
    }
}