package org.example._61.rotate.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListInfo info = findInfo(head);
        k %= info.size;
        if (k == 0) return head;

        int index = 1;
        int target = info.size - k;
        ListNode current = head;
        while (index != target) {
            index++;
            current = current.next;
        }
        ListNode newHead = current.next;
        current.next = null;
        info.tail.next = head;
        return newHead;
    }

    private ListInfo findInfo(ListNode node) {
        int size = 0;
        ListNode prev = node;
        while (node != null) {
            size++;
            prev = node;
            node = node.next;
        }
        return new ListInfo(size, prev);
    }

    private record ListInfo(int size, ListNode tail) {
    }
}
