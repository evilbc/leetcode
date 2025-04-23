package org.example._1399.count.largest.group;

class Solution {
    private static final int MAX_SUM = 36;

    public int countLargestGroup(int n) {
        int[] sumCounts = new int[MAX_SUM + 1];
        int maxCount = 0;
        int howManyMaxCount = 0;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 1_000 == 0) {
                sum -= 26;
            } else if (i % 100 == 0) {
                sum -= 17;
            } else if (i % 10 == 0) {
                sum -= 8;
            } else {
                sum++;
            }
            int count = ++sumCounts[sum];
            if (count > maxCount) {
                maxCount = count;
                howManyMaxCount = 1;
            } else if (count == maxCount) {
                howManyMaxCount++;
            }
        }
        return howManyMaxCount;
    }
}