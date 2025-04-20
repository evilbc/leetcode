package org.example._781.rabbits.in.forest;

class Solution {
    private static final int MAX_NUM = 1000;

    public int numRabbits(int[] answers) {
        int[] answerCount = new int[MAX_NUM];
        int result = 0;
        for (int answer : answers) {
            if (answerCount[answer]++ % (answer + 1) == 0) result += answer + 1;
        }
        return result;
    }
}
