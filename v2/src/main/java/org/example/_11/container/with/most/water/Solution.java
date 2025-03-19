package org.example._11.container.with.most.water;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        List<Integer> leftPossibilities = new ArrayList<>(2 * height.length + 2);
        int lastLeft = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > lastLeft) {
                lastLeft = height[i];
                leftPossibilities.add(i);
                leftPossibilities.add(height[i]);
            }
            for (int j = 0; j < leftPossibilities.size(); j += 2) {
                int area = (i - leftPossibilities.get(j)) * Math.min(leftPossibilities.get(j + 1), height[i]);
                if (area > maxArea)
                    maxArea = area;
            }
        }
        return maxArea;
    }
}
