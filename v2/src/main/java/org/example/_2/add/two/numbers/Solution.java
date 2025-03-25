package org.example._2.add.two.numbers;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        ListNode first = new ListNode();
        ListNode previous = first;
        ListNode current;

        while (l1 != null || l2 != null) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            current = new ListNode(sum % 10);
            sum /= 10;

            previous.next = current;
            previous = current;
        }
        if (sum > 0) {
            current = new ListNode(sum);
            previous.next = current;
        }
        return first.next;
    }
}
