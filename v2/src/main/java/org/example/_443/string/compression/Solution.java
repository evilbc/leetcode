package org.example._443.string.compression;

import java.util.Stack;

class Solution {
    public int compress(char[] chars) {
        if (chars.length <= 1)
            return chars.length;

        char currentChar = chars[0];
        int compressIndex = 0;
        int howMany = 1;

        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if (c == currentChar) {
                howMany++;
            } else {
                compressIndex = writeCompressed(chars, compressIndex, currentChar, howMany);
                currentChar = c;
                howMany = 1;
            }
        }

        compressIndex = writeCompressed(chars, compressIndex, currentChar, howMany);
        return compressIndex;
    }

    // return - new compressIndex
    private int writeCompressed(char[] chars, int compressIndex, char c, int howMany) {
        chars[compressIndex++] = c;
        if (howMany == 1)
            return compressIndex;

        Stack<Character> digits = new Stack<>();
        while (howMany > 0) {
            digits.push((char) ('0' + (howMany % 10)));
            howMany /= 10;
        }
        while (!digits.isEmpty()) {
            chars[compressIndex++] = digits.pop();
        }

        return compressIndex;
    }
}