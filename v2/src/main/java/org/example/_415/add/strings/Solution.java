package org.example._415.add.strings;

class Solution {
    public String addStrings(String num1, String num2) {
        int i1 = num1.length() - 1;
        int i2 = num2.length() - 1;
        boolean carry = false;
        StringBuilder sb = new StringBuilder();

        while (i1 >= 0 || i2 >= 0) {
            int sum = carry ? 1 : 0;
            if (i1 >= 0) sum += num1.charAt(i1--) - '0';
            if (i2 >= 0) sum += num2.charAt(i2--) - '0';

            if (sum >= 10) {
                carry = true;
                sum -= 10;
            } else carry = false;

            sb.append(sum);
        }
        if (carry) sb.append('1');
        return sb.reverse().toString();
    }
}
