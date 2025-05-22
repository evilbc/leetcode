package org.example._506.relative.ranks;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        String[] result = new String[score.length];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < score.length; i++) {
            pq.offer(new int[]{score[i], i});
        }
        int rank = score.length;
        while (!pq.isEmpty()) {
            int index = pq.poll()[1];
            result[index] = getRank(rank--);
        }

        return result;
    }

    private String getRank(int rank) {
        if (rank > 3) return Integer.toString(rank);
        if (rank == 3) return "Bronze Medal";
        if (rank == 2) return "Silver Medal";
        return "Gold Medal";
    }
}
