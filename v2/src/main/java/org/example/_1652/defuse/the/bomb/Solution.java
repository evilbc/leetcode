package org.example._1652.defuse.the.bomb;

class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];
        if (k == 0)
            return result;

        int left = 1;
        int right = k;
        if (k < 0) {
            left = getIndex(code, k);
            right = getIndex(code, -1);
        }

        int sum = calculateSum(code, left, right);
        result[0] = sum;

        for (int i = 1; i < n; i++) {
            sum -= code[left];
            sum += code[getIndex(code, right + 1)];
            result[i] = sum;
            left = getIndex(code, left + 1);
            right = getIndex(code, right + 1);
        }

        return result;
    }

    private int calculateSum(int[] code, int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += code[i];
        }
        return sum;
    }

    private int getIndex(int[] code, int i) {
        if (i >= code.length)
            return i - code.length;
        if (i < 0)
            return code.length + i;
        return i;
    }

}
