package org.example._933.number.of.recent.calls;

import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {
    private static final int RECENT_TIME = 3_000;
    private final Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        while (!queue.isEmpty() && queue.peek() < t - RECENT_TIME) {
            queue.remove();
        }
        queue.add(t);
        return queue.size();
    }
}
