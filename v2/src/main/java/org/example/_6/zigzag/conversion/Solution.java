package org.example._6.zigzag.conversion;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        List<List<Character>> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new ArrayList<>());
        }

        int direction = 1;
        int row = 0;
        for (int i = 0; i < s.length(); i++) {
            rows.get(row)
                    .add(s.charAt(i));
            if (row == numRows - 1) {
                direction = -1;
            } else if (row == 0) {
                direction = 1;
            }
            row += direction;
        }

        StringBuilder sb = new StringBuilder();
        for (List<Character> characters : rows) {
            for (Character character : characters) {
                sb.append(character);
            }
        }

        return sb.toString();
    }
}