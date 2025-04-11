package org.example._394.decode.string;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    private static final char REPETITION_START = '[';
    private static final char REPETITION_END = ']';

    public String decodeString(String s) {
        Deque<Repetition> repetitions = new LinkedList<>();
        repetitions.add(new Repetition(1));
        int num = 0;

        for (char c : s.toCharArray()) {
            if (c == REPETITION_START) {
                repetitions.add(new Repetition(num));
                num = 0;
            } else if (c == REPETITION_END) {
                Repetition repetition = repetitions.removeLast();
                repetitions.getLast().chars.repeat(repetition.chars, repetition.count);
            } else if (Character.isDigit(c)) {
                num *= 10;
                num += Character.getNumericValue(c);
            } else {
                repetitions.getLast().chars.append(c);
            }
        }

        return repetitions.getFirst().chars.toString();
    }

    private static class Repetition {
        private final int count;
        private final StringBuilder chars;

        public Repetition(int count) {
            this.count = count;
            this.chars = new StringBuilder();
        }
    }
}
