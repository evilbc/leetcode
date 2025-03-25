package org.example._66.plus.one;

class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
            if (i == 0) {
                return addNewDigit(digits);
            }
        }

        return digits;
    }

    private int[] addNewDigit(int[] digits) {
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        System.arraycopy(digits, 0, newDigits, 1, digits.length);
        return newDigits;
    }
}
