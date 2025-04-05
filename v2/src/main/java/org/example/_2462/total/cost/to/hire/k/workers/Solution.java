package org.example._2462.total.cost.to.hire.k.workers;

import java.util.PriorityQueue;

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        long result = 0;
        PriorityQueue<Integer> leftQueue = new PriorityQueue<>();
        PriorityQueue<Integer> rightQueue = new PriorityQueue<>();
        int left = 0;
        while (left < candidates) {
            leftQueue.add(costs[left]);
            left++;
        }
        int right = costs.length - 1;
        while (right >= left && costs.length - candidates <= right) {
            rightQueue.add(costs[right]);
            right--;
        }

        for (int i = 0; i < k; i++) {
            int leftVal = leftQueue.isEmpty() ? Integer.MAX_VALUE : leftQueue.peek();
            int rightVal = rightQueue.isEmpty() ? Integer.MAX_VALUE : rightQueue.peek();
            if (leftVal <= rightVal) {
                leftQueue.remove();
                result += leftVal;
            } else {
                rightQueue.remove();
                result += rightVal;
            }
            if (left > right)
                continue;
            if (leftVal <= rightVal) {
                leftQueue.add(costs[left]);
                left++;
            } else {
                rightQueue.add(costs[right]);
                right--;
            }
        }

        return result;
    }
}