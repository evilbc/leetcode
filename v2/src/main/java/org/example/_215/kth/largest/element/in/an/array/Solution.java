package org.example._215.kth.largest.element.in.an.array;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            pq.add(num);
        }
        for (int i = 0; i < k - 1; i++) {
            pq.remove();
        }
        return pq.remove();
    }
}