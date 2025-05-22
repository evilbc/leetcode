package org.example._401.binary.watch;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class Solution {
    private int[] BITS = new int[]{512, 256, 128, 64, 32, 16, 8, 4, 2, 1};

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        readBinaryWatch(turnedOn, 0, 0, result);
        return result;
    }

    private void readBinaryWatch(int turnedOn, int index, int current, List<String> results) {
        if (turnedOn == 0) {
            readTime(current).ifPresent(results::add);
            return;
        }

        for (int i = index; i < BITS.length - turnedOn + 1; i++) {
            readBinaryWatch(turnedOn - 1, i + 1, current + BITS[i], results);
        }
    }

    private Optional<String> readTime(int current) {
        int hour = current / 64;
        int minute = current % 64;
        if (hour > 11 || minute > 59) {
            return Optional.empty();
        }

        return Optional.of(String.format("%d:%02d", hour, minute));
    }
}
