package org.example._492.construct.the.rectangle;

class Solution {
    public int[] constructRectangle(int area) {
        for (int i = (int) Math.sqrt(area); i > 0; i--) {
            if (area % i == 0) return new int[]{area / i, i};
        }
        throw new IllegalStateException();
    }
}
