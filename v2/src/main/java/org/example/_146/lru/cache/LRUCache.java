package org.example._146.lru.cache;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class LRUCache {
    private static final int NO_KEY = -1;
    private final int[] recent;
    private final Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        recent = new int[capacity];
        map = new HashMap<>();
        Arrays.fill(recent, NO_KEY);
    }

    public int get(int key) {
        useKey(key, false);
        return map.getOrDefault(key, NO_KEY);
    }

    public void put(int key, int value) {
        useKey(key, true);
        map.put(key, value);
    }

    private void useKey(int key, boolean adding) {
        int i = 0;
        while (i < recent.length && recent[i] != NO_KEY) {
            if (recent[i] == key) {
                shiftUp(i);
                return;
            }
            i++;
        }

        if (!adding)
            return;
        i = Math.min(i, recent.length - 1);
        map.remove(recent[i]);
        recent[i] = key;
        shiftUp(i);
    }

    private void shiftUp(int index) {
        for (int i = index - 1; i >= 0; i--) {
            int tmp = recent[i];
            recent[i] = recent[i + 1];
            recent[i + 1] = tmp;
        }
    }
}
