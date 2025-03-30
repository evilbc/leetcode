package org.example._547.number.of.provinces;

import java.util.HashSet;
import java.util.Set;

class Solution {
    private static final int CONNECTED = 1;

    public int findCircleNum(int[][] isConnected) {
        Set<Integer> visited = new HashSet<>();
        int provinces = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (visited.contains(i)) {
                continue;
            }
            provinces++;
            visitConnected(isConnected, i, visited);
        }
        return provinces;
    }

    private void visitConnected(int[][] isConnected, int province, Set<Integer> visited) {
        if (visited.contains(province))
            return;
        visited.add(province);

        for (int other = 0; other < isConnected.length; other++) {
            if (isConnected[province][other] == CONNECTED)
                visitConnected(isConnected, other, visited);
        }
    }
}
