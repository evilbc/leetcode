package org.example._405.convert.a.number.to.hexadecimal;

class Solution {
    private static final int BITS_PER_HEX = 4;
    private static final int AND = 0b1111;
    private static final Character[] DIGITS = new Character[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public String toHex(int num) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int digit = num & AND;
            sb.append(DIGITS[digit]);
            num >>>= BITS_PER_HEX;
        }

        return sb.reverse().toString();
    }
}
