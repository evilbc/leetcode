package org.example._3545.minimum.deletions._for.at.most.k.distinct.characters;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int minDeletion(String s, int k) {
        Map<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            counts.compute(s.charAt(i), (key, v) -> v == null ? 1 : v + 1);
        }
        if (counts.size() <= k) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Integer count : counts.values()) {
            pq.add(count);
        }
        int deletions = 0;
        for (int i = 0; i < counts.size() - k; i++) {
            deletions += pq.remove();
        }
        return deletions;
    }
}