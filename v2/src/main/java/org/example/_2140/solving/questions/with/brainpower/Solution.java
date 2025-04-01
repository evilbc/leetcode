package org.example._2140.solving.questions.with.brainpower;

class Solution {
    public long mostPoints(int[][] questions) {
        long[] maxPoints = new long[questions.length];
        maxPoints[questions.length - 1] = questions[questions.length - 1][0];

        for (int i = questions.length - 2; i >= 0; i--) {
            int[] question = questions[i];
            long solvePoints = question[0];
            int brainpower = question[1];

            int nextPossible = brainpower + i + 1;
            if (nextPossible < maxPoints.length) {
                solvePoints += maxPoints[nextPossible];
            }
            long skipPoints = maxPoints[i + 1];
            maxPoints[i] = Math.max(skipPoints, solvePoints);
        }
        return maxPoints[0];
    }
}
