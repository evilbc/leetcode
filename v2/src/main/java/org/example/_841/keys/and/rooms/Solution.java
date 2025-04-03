package org.example._841.keys.and.rooms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();

        Queue<Integer> toVisit = new LinkedList<>();
        toVisit.add(0);

        while (!toVisit.isEmpty()) {
            int curr = toVisit.poll();
            visited.add(curr);
            for (Integer key : rooms.get(curr)) {
                if (!visited.contains(key)) {
                    visited.add(key);
                    toVisit.add(key);
                }
            }
            if (visited.size() == rooms.size())
                return true;
        }

        return false;
    }
}
