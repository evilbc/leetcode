package org.example._2843.count.symmetric.integers;

class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            String s = Integer.toString(i);
            int digitCount = s.length();
            if (digitCount % 2 == 1) {
                i = (int) Math.pow(10, digitCount);
                continue;
            }

            if (isSymmetric(s))
                count++;
        }
        return count;
    }

    private boolean isSymmetric(String s) {
        int diff = 0;
        for (int i = 0; i < s.length() / 2; i++) {
            diff += s.charAt(i) - s.charAt(s.length() - i - 1);
        }
        return diff == 0;
    }

}
