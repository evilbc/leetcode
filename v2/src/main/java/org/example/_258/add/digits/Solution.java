package org.example._258.add.digits;

class Solution {
    public int addDigits(int num) {
        if (num < 10) return num;
        String str = Integer.toString(num);

        int digitSum = 0;
        for (int i = 0; i < str.length(); i++) {
            digitSum += str.charAt(i) - '0';
        }
        return addDigits(digitSum);
    }
}