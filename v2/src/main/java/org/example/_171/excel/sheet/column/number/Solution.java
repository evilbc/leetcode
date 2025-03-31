package org.example._171.excel.sheet.column.number;

class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        int mult = 1;

        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            char c = columnTitle.charAt(i);
            int num = c - 'A' + 1;
            result += num * mult;
            mult *= 'Z' - 'A' + 1;
        }

        return result;
    }
}
