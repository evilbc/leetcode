package org.example._1184.distance.between.bus.stops;

class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        return Math.min(traverseClockwise(distance, start, destination),
                traverseCounterClockwise(distance, start, destination));
    }

    private int traverseClockwise(int[] distance, int start, int destination) {
        if (start == destination)
            return 0;

        return distance[start] + traverseClockwise(distance, (start + 1) % distance.length, destination);
    }

    private int traverseCounterClockwise(int[] distance, int start, int destination) {
        if (start == destination)
            return 0;

        start = (start == 0) ? distance.length - 1 : start - 1;

        return distance[start] + traverseCounterClockwise(distance, start, destination);
    }
}
