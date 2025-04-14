package org.example._2542.maximum.subsequence.score;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

    public long maxScore(int[] nums1, int[] nums2, int k) {
        List<Pair> pairs = new ArrayList<>(nums1.length);
        for (int i = 0; i < nums1.length; i++) {
            pairs.add(new Pair(nums1[i], nums2[i]));
        }
        pairs.sort((p1, p2) -> p2.min - p1.min);

        long sum = 0;
        long max = Integer.MIN_VALUE;
        PriorityQueue<Integer> lowestSums = new PriorityQueue<>();
        for (Pair pair : pairs) {
            lowestSums.add(pair.sum);
            sum += pair.sum;
            if (lowestSums.size() == k) {
                max = Math.max(max, sum * pair.min);
                sum -= lowestSums.remove();
            }
        }
        return max;
    }

    private record Pair(int sum, int min) {
    }
}
