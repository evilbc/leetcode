package org.example._735.asteroid.collision;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> stack = new ArrayList<>();

        for (int asteroid : asteroids) {
            if (stack.isEmpty()) {
                stack.addLast(asteroid);
                continue;
            }
            boolean shouldAdd = false;
            while (!stack.isEmpty()) {
                shouldAdd = false;
                int prev = stack.getLast();
                if (Math.signum(asteroid) == Math.signum(prev) || (prev < 0 && asteroid > 0)) {
                    stack.addLast(asteroid);
                    break;
                }
                if (Math.abs(asteroid) == Math.abs(prev)) {
                    stack.removeLast();
                    break;
                } else if (Math.abs(asteroid) > Math.abs(prev)) {
                    stack.removeLast();
                    shouldAdd = true;
                } else {
                    break;
                }
            }
            if (shouldAdd)
                stack.addLast(asteroid);
        }

        return toArray(stack);
    }

    private int[] toArray(List<Integer> list) {
        int[] arr = new int[list.size()];
        int i = 0;
        for (int num : list) {
            arr[i++] = num;
        }
        return arr;
    }
}
