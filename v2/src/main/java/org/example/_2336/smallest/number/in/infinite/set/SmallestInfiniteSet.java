package org.example._2336.smallest.number.in.infinite.set;

import java.util.PriorityQueue;

class SmallestInfiniteSet {
    private static final int MAX_REQUESTS = 1_001;
    private int current;
    private PriorityQueue<Integer> addedBack;

    public SmallestInfiniteSet() {
        addedBack = new PriorityQueue<>(MAX_REQUESTS);
        current = 1;

    }

    public int popSmallest() {
        if (!addedBack.isEmpty()) {
            return addedBack.poll();
        }
        return current++;
    }

    public void addBack(int num) {
        if (num < current && !addedBack.contains(num))
            addedBack.offer(num);
    }
}
