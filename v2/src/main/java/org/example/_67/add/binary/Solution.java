package org.example._67.add.binary;

import java.util.Arrays;

class Solution {
    public String addBinary(String a, String b) {
        boolean carry = false;

        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        StringBuilder sb = new StringBuilder();

        while (aIndex >= 0 || bIndex >= 0) {
            int sum = 0;
            if (aIndex >= 0) sum += a.charAt(aIndex--) - '0';
            if (bIndex >= 0) sum += b.charAt(bIndex--) - '0';
            if (carry) sum++;

            carry = sum > 1;
            sb.append(sum % 2);
        }
        if (carry) sb.append(1);

        return sb.reverse().toString();
    }
}
