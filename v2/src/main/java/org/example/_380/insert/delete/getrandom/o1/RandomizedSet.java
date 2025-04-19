package org.example._380.insert.delete.getrandom.o1;

import java.util.*;

class RandomizedSet {
    private final List<Integer> list;
    private final Map<Integer, Integer> numIndexes;
    private final Random random;

    public RandomizedSet() {
        list = new ArrayList<>();
        numIndexes = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (numIndexes.containsKey(val))
            return false;

        numIndexes.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!numIndexes.containsKey(val))
            return false;

        int index = numIndexes.remove(val);
        if (index != list.size() - 1) {
            int lastNum = list.getLast();
            list.set(index, lastNum);
            numIndexes.put(lastNum, index);
        }
        list.removeLast();
        return true;
    }

    public int getRandom() {
        int num = random.nextInt(list.size());
        return list.get(num);
    }
}