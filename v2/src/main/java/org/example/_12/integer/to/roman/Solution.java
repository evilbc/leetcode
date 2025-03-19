package org.example._12.integer.to.roman;

class Solution {
    private static final String THOUSAND = "M";
    private static final String FIVE_HUNDRED = "D";
    private static final String HUNDRED = "C";
    private static final String FIFTY = "L";
    private static final String TEN = "X";
    private static final String FIVE = "V";
    private static final String ONE = "I";

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            if (num >= 1_000) {
                sb.append(THOUSAND);
                num -= 1_000;
            } else if (num >= 900) {
                sb.append(HUNDRED)
                        .append(THOUSAND);
                num -= 900;
            } else if (num >= 500) {
                sb.append(FIVE_HUNDRED);
                num -= 500;
            } else if (num >= 400) {
                sb.append(HUNDRED)
                        .append(FIVE_HUNDRED);
                num -= 400;
            } else if (num >= 100) {
                sb.append(HUNDRED);
                num -= 100;
            } else if (num >= 90) {
                sb.append(TEN)
                        .append(HUNDRED);
                num -= 90;
            } else if (num >= 50) {
                sb.append(FIFTY);
                num -= 50;
            } else if (num >= 40) {
                sb.append(TEN)
                        .append(FIFTY);
                num -= 40;
            } else if (num >= 10) {
                sb.append(TEN);
                num -= 10;
            } else if (num >= 9) {
                sb.append(ONE)
                        .append(TEN);
                num -= 9;
            } else if (num >= 5) {
                sb.append(FIVE);
                num -= 5;
            } else if (num >= 4) {
                sb.append(ONE)
                        .append(FIVE);
                num -= 4;
            } else {
                sb.append(ONE);
                num -= 1;
            }
        }
        return sb.toString();
    }
}
